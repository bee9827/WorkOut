package GraduationProject.WorkOut.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PoseLandmark {
    @Id
    @GeneratedValue
    @Column(name = "pose_landmark_id")
    private Integer id;

}
