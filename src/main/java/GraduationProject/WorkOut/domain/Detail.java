package GraduationProject.WorkOut.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Detail {
    @Id
    @GeneratedValue
    @Column(name = "datail_id")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    private PoseLandmark poseLandmark;

    private Integer count;
    private String passedTime;

}
