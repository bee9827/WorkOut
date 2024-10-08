package GraduationProject.WorkOut.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    @Column(name = "exercise_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Video video;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Detail> details = new ArrayList<>();

    private LocalTime targetTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private Integer targetCount;
    private Integer totalCount;



}
