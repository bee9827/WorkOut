package GraduationProject.WorkOut.domain.dto;

import GraduationProject.WorkOut.domain.Exercise;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DetailResponseDto {
    private Integer userId;
    private TypeDto typeDto;
    ExerciseDto exerciseDto;
    List<DetailDto> detailDtos;

    public DetailResponseDto(Exercise exercise) {
        userId = exercise.getUsers().getUserId();
        typeDto = new TypeDto(exercise.getType());
        exerciseDto = new ExerciseDto(exercise);
        detailDtos = exercise.getDetails().stream().map(DetailDto::new).toList();
    }
}
