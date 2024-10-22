package GraduationProject.WorkOut.domain.dto;

import GraduationProject.WorkOut.domain.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponseDto {
    private Integer userId;
    private String name;
    private String email;
    private String phoneNumber;

    public UserResponseDto(Users users) {
        this.userId = users.getUserId();
        this.name = users.getName();
        this.email = users.getEmail();
        this.phoneNumber = users.getPhoneNumber();
    }
}
