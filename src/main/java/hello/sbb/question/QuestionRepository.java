package hello.sbb.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/* JpaRepository는 기본적인 crud 기능을 지원한다.
* Question테이블의 기본키는 int형이라는 것을 작성해야 함*/
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject); //findBySubject은 findById처럼 정의되어있지 않기 때문에 직접 정의
    Question findBySubjectAndContent(String subject, String content); //And를 활용해 데이터베이스에서 두 개의 열 조회
    List<Question> findBySubjectLike(String subject);
}
