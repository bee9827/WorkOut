package GraduationProject.WorkOut.domain;

import GraduationProject.WorkOut.domain.dto.ExerciseDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Exercise {

    @Id
    @GeneratedValue
    private Integer exerciseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Video video;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL)
    private List<Detail> details = new ArrayList<>();

    private LocalTime targetTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private Integer targetCount;
    private Integer totalCount;

    public void setType(Type type) {
       this.type = type;
       type.getExercise().add(this);
    }

    public void addDetails(List<Detail> details) {
        if (details != null) {
            details.forEach(detail -> detail.setExercise(this));
            this.details.addAll(details);
        }
    }

    @Builder
    public Exercise(Type type, Member member, Video video, List<Detail> details, LocalTime targetTime, LocalDateTime startTime, LocalDateTime endTime, Integer targetCount, Integer totalCount) {
        this.type = type;
        this.type.getExercise().add(this);
        this.member = member;
        this.video = video;
        addDetails(details);
        this.targetTime = targetTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.targetCount = targetCount;
        this.totalCount = totalCount;
    }

}
