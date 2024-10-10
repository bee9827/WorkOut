package GraduationProject.WorkOut.controller;

import GraduationProject.WorkOut.domain.Exercise;
import GraduationProject.WorkOut.domain.dto.ExerciseRequestDto;
import GraduationProject.WorkOut.domain.dto.ExerciseResponseDto;
import GraduationProject.WorkOut.repository.ExerciseRepository;
import GraduationProject.WorkOut.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseService exerciseService;
    private final ExerciseRepository exerciseRepository;

    @GetMapping("api/exercise")
    public ResponseEntity<ExerciseResponseDto> getExercises(
            @RequestParam Integer memberId,
            @RequestParam LocalDate month) {
        return ResponseEntity.ok(exerciseService.findAll(memberId,month));
    }
    @DeleteMapping("api/exercise")
    public ResponseEntity<Void> deleteExercise(@RequestParam Integer exerciseId) {
        exerciseRepository.deleteById(exerciseId);
        return ResponseEntity.ok().build();
    }
    @PostMapping("api/exercise/details")
    public ResponseEntity<Integer> createExercise(@RequestBody ExerciseRequestDto exerciseRequestDto) {
        System.out.println(exerciseRequestDto.getExerciseDto().getStartTime());
        return ResponseEntity.status(HttpStatus.CREATED).body(exerciseService.save(exerciseRequestDto));
    }

}
