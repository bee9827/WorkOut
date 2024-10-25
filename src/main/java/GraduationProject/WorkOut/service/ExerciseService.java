package GraduationProject.WorkOut.service;

import GraduationProject.WorkOut.domain.Detail;
import GraduationProject.WorkOut.domain.Exercise;
import GraduationProject.WorkOut.domain.User;
import GraduationProject.WorkOut.domain.Type;
import GraduationProject.WorkOut.domain.dto.*;
import GraduationProject.WorkOut.exception.NotFoundException;
import GraduationProject.WorkOut.repository.DetailRepository;
import GraduationProject.WorkOut.repository.ExerciseRepository;
import GraduationProject.WorkOut.repository.UserRepository;
import GraduationProject.WorkOut.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final UserRepository userRepository;
    private final TypeRepository typeRepository;
    private final DetailRepository detailRepository;

    public Map<LocalDate,ExerciseListDto> findThisMonthAndLastMonthByUserId(Integer userId) {
        userRepository.findById(userId).orElseThrow(
                ()-> new NotFoundException(
                        String.format("User[%d] not found", userId)));

        LocalDate thisMonth = LocalDate.now().minusMonths(1);
        LocalDate lastMonth = LocalDate.now().minusMonths(1);

        List<ExerciseResponseDto> thisMonthExercisesDto = exerciseRepository.findMonthAgoByUserId(userId,0)
                .stream()
                .map(ExerciseResponseDto::new)
                .toList();
        List<ExerciseResponseDto> lastMonthExercisesDto = exerciseRepository.findMonthAgoByUserId(userId,1)
                .stream()
                .map(ExerciseResponseDto::new)
                .toList();
        Map<LocalDate,ExerciseListDto> exerciseListDtoMap = new HashMap<>();
        exerciseListDtoMap.put(thisMonth,new ExerciseListDto(thisMonthExercisesDto));
        exerciseListDtoMap.put(lastMonth,new ExerciseListDto(lastMonthExercisesDto));

        return exerciseListDtoMap;
    }
    public DetailResponseDto findAllDetailByExerciseId(Integer exerciseId) {
        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new NotFoundException(String.format("Exercise[%d] not found", exerciseId)));
        return new DetailResponseDto(exercise);
    }

    @Transactional
    public Integer create(ExerciseRequestDto requestDto) {
        User user = userRepository
                .findById(requestDto.getUserId())
                .orElseThrow(() -> new NotFoundException(String.format("User[%d] not found", requestDto.getUserId())));
        Type type = typeRepository
                .findById(requestDto.getTypeId())
                .orElseThrow(() -> new NotFoundException(String.format("Type[%d] not found", requestDto.getTypeId())));

        List<Detail> details =
                requestDto.getDetailDtos()
                    .stream()
                    .map(DetailDto::toEntity)
                    .toList();
        Exercise exercise =
                requestDto.getExerciseDto()
                .toEntity(user,type,null);


        exercise.setDetails(details);
        exerciseRepository.save(exercise);

       return exercise.getExerciseId();
    }

    @Transactional
    public DetailResponseDto update(ExerciseRequestDto requestDto) {
        Exercise exercise = exerciseRepository.findById(requestDto.getExerciseDto().getExerciseId())
                .orElseThrow(()-> new NotFoundException(
                        String.format("Exercise[%d] not found", requestDto.getExerciseDto().getExerciseId())));
        Type type = typeRepository.findById(requestDto.getTypeId())
                .orElseThrow(() -> new NotFoundException(
                        String.format("Type[%d] not found", requestDto.getTypeId())));

        exercise.update(type);
        List<Detail> details = exercise.getDetails();
        for(int i=0; i<details.size(); i++){
            Detail detail = details.get(i);
            detail.update(requestDto.getDetailDtos().get(i).getPassedTime());
        }

        return new DetailResponseDto(exercise);
    }

    @Transactional
    public void deleteById(Integer exerciseId) {
        exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Exercise[%d] not found", exerciseId)));

        exerciseRepository.deleteById(exerciseId);
    }

    public ExerciseListDto findAll() {
        List<ExerciseResponseDto> exerciseResponseDtos = exerciseRepository.findAll()
                .stream()
                .map(ExerciseResponseDto::new)
                .toList();
        return new ExerciseListDto(exerciseResponseDtos);
    }
}
