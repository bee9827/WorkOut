package GraduationProject.WorkOut.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Video {
    @Id
    @GeneratedValue
    @Column(name = "video_id")
    private Integer id;
    private String originName;
    private String savedName;
    private String size;
    private LocalDate createdAt;
    private String type;
    private String url;
}
