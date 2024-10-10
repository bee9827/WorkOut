package GraduationProject.WorkOut.controller;

import GraduationProject.WorkOut.domain.Exercise;
import GraduationProject.WorkOut.domain.dto.DetailResponseDto;
import GraduationProject.WorkOut.domain.dto.ExerciseListDto;
import GraduationProject.WorkOut.domain.dto.ExerciseRequestDto;
import GraduationProject.WorkOut.domain.dto.ExerciseResponseDto;
import GraduationProject.WorkOut.repository.ExerciseRepository;
import GraduationProject.WorkOut.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseService exerciseService;
    private final ExerciseRepository exerciseRepository;

    @GetMapping("api/exercise")
    public ResponseEntity<ExerciseListDto> getExercises(
            @RequestParam Integer memberId,
            @RequestParam LocalDate month) {
        return ResponseEntity.ok(exerciseService.findAll(memberId,month));
    }

    @DeleteMapping("api/exercise/{exerciseId}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Integer exerciseId) {
        exerciseRepository.deleteById(exerciseId);
        return ResponseEntity.ok().build();
    }


    @PostMapping("api/exercise/details")
    public ResponseEntity<DetailResponseDto> createExercise(@RequestBody ExerciseRequestDto exerciseRequestDto) {
        System.out.println(exerciseRequestDto.getExerciseDto().getStartTime());
        return ResponseEntity.status(HttpStatus.CREATED).body(exerciseService.save(exerciseRequestDto));
    }

    @GetMapping("api/exercise/{exerciseId}/details")
    public ResponseEntity<DetailResponseDto> getDetails(@PathVariable Integer exerciseId) {
        return ResponseEntity.ok(exerciseService.findAllDetailByExerciseId(exerciseId));
    }

    @PatchMapping("api/exercise/details")
    public ResponseEntity<DetailResponseDto> updateDetails(@RequestBody ExerciseRequestDto exerciseRequestDto) {
        return ResponseEntity.ok(exerciseService.update(exerciseRequestDto));
    }



}
