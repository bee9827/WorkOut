package GraduationProject.WorkOut.domain.dto;

import GraduationProject.WorkOut.domain.Exercise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseResponseDto {
    private Integer memberId;
    private TypeDto typeDto;
    private ExerciseDto exerciseDto;

    public ExerciseResponseDto(Exercise exercise) {
         memberId = exercise.getMember().getMemberId();
         typeDto = new TypeDto(exercise.getType());
         exerciseDto = new ExerciseDto(exercise);
    }
}
