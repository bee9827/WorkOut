package GraduationProject.WorkOut.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue
    private Integer memberId;

    //멤버 권한관련 수정필요!

    private String name;
    private String email;
    private String phone;
    private String password;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

}
