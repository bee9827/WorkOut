package GraduationProject.WorkOut.service;

import GraduationProject.WorkOut.domain.Detail;
import GraduationProject.WorkOut.domain.Exercise;
import GraduationProject.WorkOut.domain.Member;
import GraduationProject.WorkOut.domain.Type;
import GraduationProject.WorkOut.domain.dto.DetailDto;
import GraduationProject.WorkOut.domain.dto.ExerciseDto;
import GraduationProject.WorkOut.domain.dto.ExerciseRequestDto;
import GraduationProject.WorkOut.domain.dto.ExerciseResponseDto;
import GraduationProject.WorkOut.repository.DetailRepository;
import GraduationProject.WorkOut.repository.ExerciseRepository;
import GraduationProject.WorkOut.repository.MemberRepository;
import GraduationProject.WorkOut.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final MemberRepository memberRepository;
    private final TypeRepository typeRepository;
    private final DetailRepository detailRepository;

    public ExerciseResponseDto findAll(Integer member_id, LocalDate month) {
        List<ExerciseDto> exercises = exerciseRepository
                .findAllByMemberIdAndMonth(
                        member_id, month)
                .stream()
                .map(ExerciseDto::new)
                .toList();

        return new ExerciseResponseDto(
                member_id,
                exercises.size(),
                exercises);
    }

    @Transactional
    public Integer save(ExerciseRequestDto requestDto) {
        Member member = memberRepository
                .findById(requestDto.getMemberId())
                .get();
        Type type = typeRepository
                .findById(requestDto.getTypeId())
                .get();
        List<Detail> details =
                requestDto.getDetailDtos()
                    .stream()
                    .map(DetailDto::toEntity)
                    .toList();
        Exercise exercise =
                requestDto.getExerciseDto()
                .toEntity(member,type,null);


        exercise.addDetails(details);
        exerciseRepository.save(exercise);

        return exercise.getExerciseId();
    }
}
