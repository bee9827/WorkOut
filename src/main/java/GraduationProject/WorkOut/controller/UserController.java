package GraduationProject.WorkOut.controller;

import GraduationProject.WorkOut.domain.dto.UserRequestDto;
import GraduationProject.WorkOut.domain.dto.UserResponseDto;
import GraduationProject.WorkOut.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("api/user")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {

        Integer userId = userService.create(userRequestDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(userId)
                .toUri();

        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("api/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer userId) {
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("api/user/{userId}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Integer userId) {
        UserResponseDto userResponseDto = userService.findById(userId);
        return ResponseEntity.ok(userResponseDto);
    }

}
