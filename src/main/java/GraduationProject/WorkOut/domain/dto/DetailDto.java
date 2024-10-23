package GraduationProject.WorkOut.domain.dto;

import GraduationProject.WorkOut.domain.Detail;
import GraduationProject.WorkOut.domain.PoseLandmark;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class DetailDto {
    private Integer detailId;
    private PoseLandmark poseLandmark;
    @Positive(message = "횟수는 음수를 입력 하실 수 없습니다.")
    private Integer count;
    @Past(message = "날짜는 미래를 입력 하실 수 없습니다.")
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
