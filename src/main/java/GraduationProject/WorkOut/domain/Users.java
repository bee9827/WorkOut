package GraduationProject.WorkOut.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Users {
    @Id
    @GeneratedValue
    private Integer userId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    List<Exercise> exercises;
    //멤버 권한관련 수정필요!
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private boolean activated;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @Builder
    public Users(Integer userId, String name, String email, String phoneNumber, String password, boolean activated, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.activated = activated;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
