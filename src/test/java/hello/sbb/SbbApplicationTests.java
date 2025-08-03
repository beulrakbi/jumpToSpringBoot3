package hello.sbb;

import hello.sbb.answer.Answer;
import hello.sbb.answer.AnswerRepository;
import hello.sbb.question.Question;
import hello.sbb.question.QuestionRepository;
import hello.sbb.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest //스프링 부트의 테스트 클래스임을 나타냄
class SbbApplicationTests {

    @Autowired //의존성 주입이라는 기능을 사용하여 QuestionRepository의 객체를 주입
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerRepository answerRepository;

    //sbbAplicationTest를 실행하면 Test 어노테이션이 붙은 testJpa메서드가 실행된다.
    @Test
    void testJpa() {
        Optional<Question> oq = this.questionRepository.findById(1);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        q.setSubject("수정된 제목");
        this.questionRepository.save(q);
    }

    @Test
    void deleteTest() {
        assertEquals(2, this.questionRepository.count());
        Optional<Question> oq = this.questionRepository.findById(1);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        this.questionRepository.delete(q);
        assertEquals(1, this.questionRepository.count());
    }

    @Test
    void saveTest() {
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        /*question 열에 데이터를 생성하려면 질문 데이터를 조회해야 함*/

        Answer a = new Answer();
        a.setContent("네 자동으로 생성됩니다.");
        a.setQuestion(q);
        a.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(a);
    }

    @Test
    void findAnswerTest() {
        Optional<Answer> oa = this.answerRepository.findById(1);
        assertTrue(oa.isPresent());
        Answer a = oa.get();
        assertEquals(2, a.getQuestion().getId());
    }

    @Transactional
    @Test
    void 질문데이터에서답변데이터(){
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();

        assertEquals(1, answerList.size());
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
    }

    @Test
    void 페이징을위한대량데이터생성(){
        for(int i=1; i<=300; i++){
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용 없음";
            this.questionService.create(subject, content);
        }
    }
}
