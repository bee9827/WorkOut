package GraduationProject.WorkOut.service;

import GraduationProject.WorkOut.domain.Exercise;
import GraduationProject.WorkOut.domain.dto.ExerciseDto;
import GraduationProject.WorkOut.domain.dto.ExerciseRequestDto;
import GraduationProject.WorkOut.domain.dto.ExerciseResponseDto;
import GraduationProject.WorkOut.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public ExerciseResponseDto findAll(ExerciseRequestDto exerciseRequestDto) {
        List<ExerciseDto> exercises = exerciseRepository
                .findAllByMemberIdAndMonth(
                        exerciseRequestDto.getMember_id(), exerciseRequestDto.getMonth())
                .stream()
                .map(ExerciseDto::new)
                .toList();

        return new ExerciseResponseDto(
                exerciseRequestDto.getMember_id(),
                exercises.size(),
                exercises);
    }
}
