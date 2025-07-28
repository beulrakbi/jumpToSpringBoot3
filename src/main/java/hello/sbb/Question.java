package hello.sbb;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity //엔티티로 식별
public class Question {
    @Id //id 속성을 기본키로 지정한다. 유효한값으로 중복되지 않게 함
    @GeneratedValue(strategy = GenerationType.IDENTITY) //데이터를 저장할 때 해당 속성에 값을 일일이 입력하지 않아도 자동으로 1씩 증가하여 저장된다.
    private Integer id;

    @Column(length = 200) //엔티티의 속성은 테이블의 열 이름과 일치하는데 열의 세부 설정을 위해 사용, lengthsms dufdml rlfdldmf tjfwjdgkf Eo tkdyd
    private String subject;

    @Column(columnDefinition = "TEXT") // 열의 데이터 유형을 TEXT로 설정, 글자 수 제한 없는 경우 사용
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) //answer 엔티티에서 question 엔티티를 참조한 속성인 question을 mappedBy에 전달, 질문이 삭제되면 답변도 삭제
    private List<Answer> answerList;
}
