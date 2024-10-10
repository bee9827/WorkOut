package GraduationProject.WorkOut.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Type {
    @Id
    @GeneratedValue
    private Integer typeId;

    @JsonIgnore
    @OneToMany(mappedBy = "type")
    private List<Exercise> exercise;

    @Enumerated(EnumType.STRING)
    private TypeStatus name;
}
