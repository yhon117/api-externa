package com.example.ApiPrueba.controller;

import com.example.ApiPrueba.dto.UsuarioDto;
import com.example.ApiPrueba.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;



    @GetMapping
    public ResponseEntity<List<UsuarioDto>>getAll(){
        return new ResponseEntity<>(usuarioService.getAll(), HttpStatus.OK);

    }

    @PostMapping
    public void saveUser(@RequestBody UsuarioDto user){
usuarioService.saveUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") Integer id,@RequestBody UsuarioDto user){

        usuarioService.updateUser(id, user);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") Integer id){

        usuarioService.deleteUser(id);
    }
}
