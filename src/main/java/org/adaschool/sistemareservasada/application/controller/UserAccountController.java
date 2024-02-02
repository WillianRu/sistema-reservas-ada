package org.adaschool.sistemareservasada.application.controller;

import org.adaschool.sistemareservasada.application.service.UserAccountService;
import org.adaschool.sistemareservasada.domain.dto.UserAccountDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public record UserAccountController(
        UserAccountService userService
) {
    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody UserAccountDTO userDTO) {
        userService.createUser(userDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity <UserAccountDTO> findMovieById(@PathVariable Integer id) throws Exception{
        UserAccountDTO user = userService.findUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody UserAccountDTO userDTO) throws Exception {
        userService.updateUser(id, userDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) throws Exception{
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
