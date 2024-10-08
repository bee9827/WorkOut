package GraduationProject.WorkOut.controller;

import GraduationProject.WorkOut.domain.dto.ExerciseRequestDto;
import GraduationProject.WorkOut.domain.dto.ExerciseResponseDto;
import GraduationProject.WorkOut.repository.ExerciseRepository;
import GraduationProject.WorkOut.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseService exerciseService;
    private final ExerciseRepository exerciseRepository;

    @GetMapping("api/exercise")
    public ResponseEntity<ExerciseResponseDto> getExercises(@RequestBody ExerciseRequestDto exerciseRequestDto) {
        return ResponseEntity.ok(exerciseService.findAll(exerciseRequestDto));
    }
    @DeleteMapping("api/exercise")
    public ResponseEntity<Void> deleteExercise(@RequestParam Integer exercise_id) {
        exerciseRepository.deleteById(exercise_id);
        return ResponseEntity.ok().build();
    }
}
