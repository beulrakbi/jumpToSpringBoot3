package hello.sbb.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true) //유일한 값만 저장 가능
    private String username;

    private String password;

    @Column(unique = true) //유일한 값만 저장 가능
    private String email;
}
