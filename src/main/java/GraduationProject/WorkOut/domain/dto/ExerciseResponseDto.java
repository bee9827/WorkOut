package GraduationProject.WorkOut.domain.dto;

import GraduationProject.WorkOut.domain.Exercise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseResponseDto {
    private Integer memberId;
    private Integer count;
    private List<ExerciseDto> exercises;

}
