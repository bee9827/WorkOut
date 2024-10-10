package GraduationProject.WorkOut.domain.dto;

import GraduationProject.WorkOut.domain.Exercise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DetailResponseDto {
    private Integer memberId;
    private TypeDto typeDto;
    ExerciseDto exerciseDto;
    List<DetailDto> detailDtos;

    public DetailResponseDto(Exercise exercise) {
        memberId = exercise.getMember().getMemberId();
        typeDto = new TypeDto(exercise.getType());
        exerciseDto = new ExerciseDto(exercise);
        detailDtos = exercise.getDetails().stream().map(DetailDto::new).toList();
    }
}
