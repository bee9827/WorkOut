package GraduationProject.WorkOut.domain.dto;

import GraduationProject.WorkOut.domain.Detail;
import GraduationProject.WorkOut.domain.PoseLandmark;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class DetailDto {
    private Integer detailId;
    private PoseLandmark poseLandmark;
    private Integer count;
    private LocalDateTime passedTime;

    public DetailDto(Detail detail) {
        this.detailId = detail.getDetailId();
        this.poseLandmark = detail.getPoseLandmark();
        this.count = detail.getCount();
        this.passedTime = detail.getPassedTime();
    }

    public Detail toEntity(){
        return Detail.builder()
                .detailId(this.detailId)
                .count(count)
                .passedTime(passedTime)
                .poseLandmark(poseLandmark)
                .build();
    }
}
