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
    public List<Exercise> findMonthAgoByUserId(Integer userId,int ago) {
        QExercise exercise = QExercise.exercise;

        //데이터 형식 맞추기, YYYY-MM-DDT00:00:00 설정
        LocalDateTime startOfLastMonth = LocalDate.now()
                .minusMonths(1+ago)
                .withDayOfMonth(1)
                .atStartOfDay();
        LocalDateTime endOfLastMonth = LocalDate.now()
                .minusMonths(ago)
                .withDayOfMonth(1)
                .atStartOfDay();

        return queryFactory
                .selectFrom(exercise)
                .where(exercise.user.userId.eq(userId))
                .where(exercise.startTime.between(startOfLastMonth, endOfLastMonth))
                .fetch();
    }
}
