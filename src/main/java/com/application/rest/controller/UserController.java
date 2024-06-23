package com.application.rest.controller;

import com.application.rest.dto.FindUserRequestDTO;
import com.application.rest.dto.UserDTO;
import com.application.rest.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*" )
    @PostMapping("/find")
    public ResponseEntity<?> getUser(@Valid @RequestBody FindUserRequestDTO findUserRequestDTO){
        Optional<UserDTO> user = userService.findUserByDNIAndDocumentType(findUserRequestDTO);
        if(user.isPresent()) return ResponseEntity.ok(user.get());

        Map<String, String> error = new HashMap<>();
        error.put("status", "404");
        error.put("message", "Usuario " +  findUserRequestDTO.getNumeroDocumento() + " no encontrado");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
