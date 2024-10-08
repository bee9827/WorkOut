package GraduationProject.WorkOut.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseRequestDto {
    private Integer member_id;
    private LocalDate month;
}
