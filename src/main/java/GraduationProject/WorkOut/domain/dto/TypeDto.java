package GraduationProject.WorkOut.domain.dto;

import GraduationProject.WorkOut.domain.Type;
import GraduationProject.WorkOut.domain.TypeStatus;
import jakarta.validation.constraints.AssertTrue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeDto {
    private Integer id;
    private TypeStatus name;

    public TypeDto(@NotNull Type type){
        this.id = type.getTypeId();
        this.name = type.getName();
    }

    public Type toEntity(){
        return Type.builder()
                .typeId(this.id)
                .name(this.name)
                .build();
    }
}
