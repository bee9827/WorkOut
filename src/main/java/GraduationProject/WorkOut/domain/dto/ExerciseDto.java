package GraduationProject.WorkOut.domain.dto;

import GraduationProject.WorkOut.domain.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
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

    public Exercise toEntity(User user, Type type, List<Detail> details) {
        return Exercise.builder()
                .user(user)
                .type(type)
                .details(details)
                .targetTime(targetTime)
                .startTime(startTime)
                .endTime(endTime)
                .targetCount(targetCount)
                .totalCount(totalCount)
                .build();
    }
}
