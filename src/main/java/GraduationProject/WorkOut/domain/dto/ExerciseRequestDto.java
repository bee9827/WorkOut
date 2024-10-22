package GraduationProject.WorkOut.domain.dto;

import GraduationProject.WorkOut.domain.Exercise;
import GraduationProject.WorkOut.domain.TypeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseRequestDto {
    private Integer userId;
    private Integer typeId;
    private ExerciseDto exerciseDto;
    private List<DetailDto> detailDtos;
}
