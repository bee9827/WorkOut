package GraduationProject.WorkOut.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Detail {
    @Id
    @GeneratedValue
    private Integer detailId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="exercise_id")
    @Setter
    private Exercise exercise;

    @OneToOne(cascade = CascadeType.ALL)
    private PoseLandmark poseLandmark;

    private Integer count;
    private String passedTime;

}
