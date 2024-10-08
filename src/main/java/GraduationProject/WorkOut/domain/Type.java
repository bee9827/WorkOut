package GraduationProject.WorkOut.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Type {
    @Id
    @GeneratedValue
    @Column(name = "type_id")
    private Integer id;

    @OneToMany(mappedBy = "type")
    private List<Exercise> exercise;

    private TypeStatus name;
}
