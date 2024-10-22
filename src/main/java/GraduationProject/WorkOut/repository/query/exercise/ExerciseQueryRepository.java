package GraduationProject.WorkOut.repository.query.exercise;

import GraduationProject.WorkOut.domain.Exercise;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExerciseQueryRepository {
    public List<Exercise> findAllByUserIdAndMonth(Integer userId, LocalDate month);
}
