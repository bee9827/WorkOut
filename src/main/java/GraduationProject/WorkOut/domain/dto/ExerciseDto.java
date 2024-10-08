package GraduationProject.WorkOut.domain.dto;

import GraduationProject.WorkOut.domain.*;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ExerciseDto {

    private String name;
    private LocalTime targetTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private Integer targetCount;
    private Integer totalCount;

    public ExerciseDto(Exercise exercise) {
        this.name = exercise.getType().getName();
        this.targetTime = exercise.getTargetTime();
        this.startTime = exercise.getStartTime();
        this.endTime = exercise.getEndTime();
        this.targetCount = exercise.getTargetCount();
        this.totalCount = exercise.getTotalCount();
    }
}
