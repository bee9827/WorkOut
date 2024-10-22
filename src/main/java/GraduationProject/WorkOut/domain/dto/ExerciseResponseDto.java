package GraduationProject.WorkOut.domain.dto;

import GraduationProject.WorkOut.domain.Exercise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseResponseDto {
    private Integer userId;
    private TypeDto typeDto;
    private ExerciseDto exerciseDto;

    public ExerciseResponseDto(Exercise exercise) {
         userId = exercise.getUsers().getUserId();
         typeDto = new TypeDto(exercise.getType());
         exerciseDto = new ExerciseDto(exercise);
    }
}
