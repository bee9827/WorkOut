package GraduationProject.WorkOut.repository;

import GraduationProject.WorkOut.domain.Exercise;
import GraduationProject.WorkOut.repository.query.exercise.ExerciseQueryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Integer>, ExerciseQueryRepository {

}
