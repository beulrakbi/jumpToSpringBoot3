package hello.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest //스프링 부트의 테스트 클래스임을 나타냄
class SbbApplicationTests {

    @Autowired //의존성 주입이라는 기능을 사용하여 QuestionRepository의 객체를 주입
    private QuestionRepository questionRepository;
    //sbbAplicationTest를 실행하면 Test 어노테이션이 붙은 testJpa메서드가 실행된다.
    @Test
    void testJpa() {
        Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
        assertEquals(1, q.getId());
    }
}
