package GraduationProject.WorkOut.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Integer id;

    //멤버 권한관련 수정필요!

    private String name;
    private String email;
    private String phone;
    private String password;
    private String createdDate;
    private String updatedDate;
    private MemberStatus status;

}
