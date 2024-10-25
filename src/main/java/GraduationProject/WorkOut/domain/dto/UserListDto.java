package GraduationProject.WorkOut.domain.dto;

import GraduationProject.WorkOut.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserListDto {
    List<UserResponseDto> users;
}
