package GraduationProject.WorkOut.controller;

import GraduationProject.WorkOut.domain.dto.UserListDto;
import GraduationProject.WorkOut.domain.dto.UserRequestDto;
import GraduationProject.WorkOut.domain.dto.UserResponseDto;
import GraduationProject.WorkOut.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("api/users")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {

        Integer userId = userService.create(userRequestDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(userId)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("api/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer userId) {
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("api/users/{userId}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Integer userId, @RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(userService.update(userRequestDto, userId));
    }

    @GetMapping("api/users/{userId}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Integer userId) {
        UserResponseDto userResponseDto = userService.findById(userId);
        return ResponseEntity.ok(userResponseDto);
    }

    @GetMapping("api/users")
    public ResponseEntity<UserListDto> getUsers() {
        UserListDto userListDto = userService.findAll();
        return ResponseEntity.ok(userListDto);
    }

}
