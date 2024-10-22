package GraduationProject.WorkOut.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private Integer userId;
    private String userName;
    private String email;
    private String phone;
}
