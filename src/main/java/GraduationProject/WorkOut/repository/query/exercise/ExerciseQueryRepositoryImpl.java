package GraduationProject.WorkOut.repository.query.exercise;

import GraduationProject.WorkOut.domain.Exercise;
import GraduationProject.WorkOut.domain.QExercise;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class ExerciseQueryRepositoryImpl implements ExerciseQueryRepository {
    private final JPAQueryFactory queryFactory;
    @Override
    public List<Exercise> findAllByMemberIdAndMonth(Integer member_id, LocalDate month) {
        QExercise exercise = QExercise.exercise;

        //YYYY-MM-01 설정
        month = month.withDayOfMonth(1);
        //데이터 형식 맞추기, YYYY-MM-DDT00:00:00 설정
        LocalDateTime date = month.atStartOfDay();

        return queryFactory
                .selectFrom(exercise)
                .where(exercise.member.id.eq(member_id))
                .where(exercise.startTime.between(date,date.plusMonths(1)))
                .fetch();
    }
}
