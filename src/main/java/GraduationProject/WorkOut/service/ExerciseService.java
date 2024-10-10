package GraduationProject.WorkOut.service;

import GraduationProject.WorkOut.domain.Detail;
import GraduationProject.WorkOut.domain.Exercise;
import GraduationProject.WorkOut.domain.Member;
import GraduationProject.WorkOut.domain.Type;
import GraduationProject.WorkOut.domain.dto.*;
import GraduationProject.WorkOut.repository.DetailRepository;
import GraduationProject.WorkOut.repository.ExerciseRepository;
import GraduationProject.WorkOut.repository.MemberRepository;
import GraduationProject.WorkOut.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final MemberRepository memberRepository;
    private final TypeRepository typeRepository;
    private final DetailRepository detailRepository;

    public ExerciseListDto findAll(Integer member_id, LocalDate month) {
        List<Exercise> exercises = exerciseRepository.findAllByMemberIdAndMonth(member_id, month);
        return new ExerciseListDto(exercises.stream().map(ExerciseResponseDto::new).toList());
    }
    public DetailResponseDto findAllDetailByExerciseId(Integer exerciseId) {
        Exercise exercise = exerciseRepository.findById(exerciseId).orElse(null);
        return new DetailResponseDto(Objects.requireNonNull(exercise));
    }

    @Transactional
    public DetailResponseDto save(ExerciseRequestDto requestDto) {
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

        return new DetailResponseDto(exercise);
    }

    @Transactional
    public DetailResponseDto update(ExerciseRequestDto requestDto) {
        Exercise exercise = exerciseRepository.findById(requestDto.getExerciseDto().getExerciseId()).get();
        Type type = typeRepository.findById(requestDto.getTypeId()).get();
        exercise.update(type);

        List<Detail> details = exercise.getDetails();
        for(int i=0; i<details.size(); i++){
            Detail detail = details.get(i);
            detail.update(requestDto.getDetailDtos().get(i).getPassedTime());
        }


        return new DetailResponseDto(exercise);
    }
}
