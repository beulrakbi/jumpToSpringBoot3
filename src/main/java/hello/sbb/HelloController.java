package hello.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/* 애너테이션 : 자바의 클래스, 메서드, 변수 등에 정보를 부여하여 부가 동작을 할 수 있게 하는 목적으로 사용*/
@Controller //HelloController 클래스가 컨트롤러의 기능을 수행한다는 것을 알려준다.
public class HelloController {
    @GetMapping("/hello") //클라이언트의 요청으로 hello메서드가 실해됨을 알려준다.
    @ResponseBody //hello 메서드의 출력값 그대로 리턴할 것임을 알려 준다.
    public String hello(){
        return "Hello Spring Boot Board";
    }
}
