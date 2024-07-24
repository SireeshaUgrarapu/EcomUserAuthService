package com.siri.EcomUserAuthService.controller;

import com.siri.EcomUserAuthService.dto.LoginRequestDTO;
import com.siri.EcomUserAuthService.dto.SignupRequestDTO;
import com.siri.EcomUserAuthService.dto.UserResponseDTO;
import com.siri.EcomUserAuthService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleNotFoundException;
import java.nio.file.attribute.UserDefinedFileAttributeView;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok(userService.login(loginRequestDTO));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> signup(@RequestBody SignupRequestDTO signupRequestDTO) throws RoleNotFoundException {
        return ResponseEntity.ok(userService.signup(signupRequestDTO));
    }

    @GetMapping("/logout")
    public ResponseEntity logout(@RequestHeader ("Authorisation") String authToken){
        return ResponseEntity.ok(userService.logout(authToken));
    }
    @GetMapping("/validate")
    public ResponseEntity<Boolean> validate(@RequestHeader ("Authorisation") String authToken){
        return ResponseEntity.ok(userService.validateToken(authToken));
    }
//    @PostMapping("/hello")
//    public ResponseEntity hello(){
//        return ResponseEntity.ok("Hello Word");
//    }
    /*
     if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove elements outside the current window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller elements from the end of deque
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            // Add current element index to deque
            deque.offerLast(i);

            // Add maximum value to result for each window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;=L
     */

}
