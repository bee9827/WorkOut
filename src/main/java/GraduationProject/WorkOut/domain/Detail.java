package GraduationProject.WorkOut.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Detail {
    @Id
    @GeneratedValue
    private Integer detailId;

    @OneToOne(cascade = CascadeType.ALL)
    private PoseLandmark poseLandmark;

    private Integer count;
    private LocalDateTime passedTime;


    public void update(LocalDateTime passedTime) {
        this.passedTime = passedTime;
    }
}
