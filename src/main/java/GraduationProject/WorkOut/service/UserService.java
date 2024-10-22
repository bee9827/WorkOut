package GraduationProject.WorkOut.service;

import GraduationProject.WorkOut.domain.Users;
import GraduationProject.WorkOut.domain.dto.UserRequestDto;
import GraduationProject.WorkOut.domain.dto.UserResponseDto;
import GraduationProject.WorkOut.exception.NotFoundException;
import GraduationProject.WorkOut.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Integer create(UserRequestDto userRequestDto) {
        Users users = userRepository.save(userRequestDto.toEntity());
        return users.getUserId();
    }
    @Transactional
    public void deleteById(Integer userId) {
        Users users = userRepository.findById(userId).orElseThrow(
                ()-> new NotFoundException(String.format("UserId[%d] not found",userId)));
        userRepository.deleteById(userId);
    }
    @Transactional
    public UserResponseDto update(UserRequestDto userRequestDto, Integer userId) {
        Users user = userRepository.findById(userId).orElseThrow(
                ()-> new NotFoundException(String.format("UserId[%d] not found",userId)));

        user.update(userRequestDto.getName(),userRequestDto.getEmail(),userRequestDto.getPassword());

        return new UserResponseDto(user);
    }
    public UserResponseDto findById(Integer userId) {
        Users users = userRepository.findById(userId).orElseThrow(
                ()-> new NotFoundException(String.format("UserId[%d] not found",userId)));
        return new UserResponseDto(users);
    }

}
