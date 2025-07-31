package hello.sbb.question;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/*
* 폼 클래스를 사용해 사요자로부터 입력받은 값을 검증*/

@Getter
@Setter
public class QuestionForm {
    @NotEmpty(message = "제목은 필수 항목입니다.") //null 또는 빈 문자열 금지
    @Size(max=200) //size 제한
    private String subject;

    @NotEmpty(message="내용은 필수 항목입니다.") //message: 검증이 실패할 경우 표시할 오류 메세지
    private String content;
}
