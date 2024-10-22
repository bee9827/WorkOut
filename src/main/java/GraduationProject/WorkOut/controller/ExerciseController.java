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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseService exerciseService;

    @GetMapping("api/exercise/user/{userId}/date/{localDate}")
    public ResponseEntity<ExerciseListDto> getExercises(
            @PathVariable Integer userId,
            @PathVariable LocalDate localDate) {
        return ResponseEntity.ok(exerciseService.findAll(userId,localDate));
    }

    @DeleteMapping("api/exercise/{exerciseId}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Integer exerciseId) {
        exerciseService.deleteById(exerciseId);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("api/exercise/details")
    public ResponseEntity<DetailResponseDto> createExercise(@RequestBody ExerciseRequestDto exerciseRequestDto) {
        Integer exerciseId = exerciseService.create(exerciseRequestDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{exerciseId}")
                .buildAndExpand(exerciseId)
                .toUri();
        return ResponseEntity.created(location).build();
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
