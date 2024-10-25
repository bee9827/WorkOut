package GraduationProject.WorkOut.service;

import GraduationProject.WorkOut.domain.User;
import GraduationProject.WorkOut.domain.dto.UserListDto;
import GraduationProject.WorkOut.domain.dto.UserRequestDto;
import GraduationProject.WorkOut.domain.dto.UserResponseDto;
import GraduationProject.WorkOut.exception.NotFoundException;
import GraduationProject.WorkOut.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Integer create(UserRequestDto userRequestDto) {
        User user = userRepository.save(userRequestDto.toEntity());
        return user.getUserId();
    }
    @Transactional
    public void deleteById(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new NotFoundException(String.format("UserId[%d] not found",userId)));
        userRepository.deleteById(userId);
    }
    @Transactional
    public UserResponseDto update(UserRequestDto userRequestDto, Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new NotFoundException(String.format("UserId[%d] not found",userId)));

        user.update(userRequestDto.getName(),userRequestDto.getEmail(),userRequestDto.getPassword());

        return new UserResponseDto(user);
    }
    public UserResponseDto findById(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new NotFoundException(String.format("UserId[%d] not found",userId)));
        return new UserResponseDto(user);
    }

    public UserListDto findAll() {
        List<UserResponseDto> userResponseDtos = userRepository.findAll()
                .stream()
                .map(UserResponseDto::new)
                .toList();

        return new UserListDto(userResponseDtos);
    }
}
