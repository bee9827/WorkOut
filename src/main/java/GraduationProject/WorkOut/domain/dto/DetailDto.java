package GraduationProject.WorkOut.domain.dto;

import GraduationProject.WorkOut.domain.Detail;
import GraduationProject.WorkOut.domain.PoseLandmark;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetailDto {
    private PoseLandmark poseLandmark;
    private Integer count;
    private String passedTime;

    public DetailDto(Detail detail) {
        this.poseLandmark = detail.getPoseLandmark();
        this.count = detail.getCount();
        this.passedTime = detail.getPassedTime();
    }

    public Detail toEntity(){
        return Detail.builder()
                .count(count)
                .passedTime(passedTime)
                .poseLandmark(poseLandmark)
                .build();
    }
}
