package com.data.session12_2.controller;


import com.data.session12_2.model.entity.User;
import com.data.session12_2.model.entity.UserMapper;
import com.data.session12_2.model.request.UserRequestDTO;
import com.data.session12_2.model.response.ApiResponse;
import com.data.session12_2.model.response.UserResponseDTO;
import com.data.session12_2.service.userService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final userService UserService;
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponseDTO>> register(@Valid @RequestBody UserRequestDTO dto) {
        User user = UserService.register(dto.getUsername(), dto.getPassword());
        UserResponseDTO responseDTO = UserMapper.toResponseDTO(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(responseDTO, "Đăng ký thành công", 201));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<UserResponseDTO>> login(@Valid @RequestBody UserRequestDTO dto, HttpSession session) {
        User user = userService.login(dto.getUsername(), dto.getPassword());
        session.setAttribute("username", user.getUsername());
        UserResponseDTO responseDTO = UserMapper.toResponseDTO(user);
        return ResponseEntity.ok(new ApiResponse<>(responseDTO, "Đăng nhập thành công", 200));
    }

    @GetMapping("/logout")
    public ResponseEntity<ApiResponse<Void>> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok(new ApiResponse<>(null, "Đăng xuất thành công", 200));
    }
}