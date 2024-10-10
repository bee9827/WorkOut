package GraduationProject.WorkOut.domain.dto;

import GraduationProject.WorkOut.domain.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ExerciseDto {

    private Integer exerciseId;

    private LocalTime targetTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private Integer targetCount;
    private Integer totalCount;

    public ExerciseDto(Exercise exercise) {
        this.exerciseId = exercise.getExerciseId();
        this.targetTime = exercise.getTargetTime();
        this.startTime = exercise.getStartTime();
        this.endTime = exercise.getEndTime();
        this.targetCount = exercise.getTargetCount();
        this.totalCount = exercise.getTotalCount();
    }

    public Exercise toEntity(Member member, Type type, List<Detail> details) {
        Exercise exercise = Exercise.builder()
                .member(member)
                .type(type)
                .details(details)
                .targetTime(targetTime)
                .startTime(startTime)
                .endTime(endTime)
                .targetCount(targetCount)
                .totalCount(totalCount)
                .build();

        return exercise;
    }
}
