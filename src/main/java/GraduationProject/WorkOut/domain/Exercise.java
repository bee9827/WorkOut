package GraduationProject.WorkOut.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
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
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Video video;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "exercise_id")
    private List<Detail> details = new ArrayList<>();

    private LocalTime targetTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private Integer targetCount;
    private Integer totalCount;

    public void setType(Type type) {
        if(type != null && !type.equals(this.type)) {
            this.type = type;
            type.getExercise().add(this);
        }
    }

    public void setDetails(List<Detail> details) {
        if (details != null) {
            this.details.addAll(details);
        }
    }

    @Builder
    public Exercise(Type type, User user, Video video, List<Detail> details, LocalTime targetTime, LocalDateTime startTime, LocalDateTime endTime, Integer targetCount, Integer totalCount) {
        setType(type);
        setDetails(details);
        this.user = user;
        this.video = video;
        this.targetTime = targetTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.targetCount = targetCount;
        this.totalCount = totalCount;
    }
    public void update(Type type) {
        setType(type);
    }

}
