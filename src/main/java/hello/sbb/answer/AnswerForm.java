package hello.sbb.answer;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
/* 답변을 달기 위한 폼*/
@Getter
@Setter
public class AnswerForm {
    @NotEmpty(message = "내용은 필수 항목입니다.")
    private String content;
}
