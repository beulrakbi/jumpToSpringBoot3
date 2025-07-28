package hello.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

/* JpaRepository는 기본적인 crud 기능을 지원한다.
* Question테이블의 기본키는 int형이라는 것을 작성해야 함*/
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject); //findBySubject은 findById처럼 정의되어있지 않기 때문에 직접 정의
}
