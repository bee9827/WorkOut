package GraduationProject.WorkOut.controller;

import GraduationProject.WorkOut.domain.dto.ExerciseRequestDto;
import GraduationProject.WorkOut.domain.dto.ExerciseResponseDto;
import GraduationProject.WorkOut.repository.ExerciseRepository;
import GraduationProject.WorkOut.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseService exerciseService;

    @GetMapping("api/exercise")
    public ResponseEntity<ExerciseResponseDto> getExercises(@RequestBody ExerciseRequestDto exerciseRequestDto) {
        return ResponseEntity.ok(exerciseService.findAll(exerciseRequestDto));
    }

}
