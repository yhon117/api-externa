package com.example.ApiPrueba.service;

import com.example.ApiPrueba.dto.UsuarioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Value("${spring.external.service.base-url}")
    private String url;

    private final RestTemplate restTemplate;



    public List <UsuarioDto> getAll(){
      UsuarioDto[] response= restTemplate.getForObject(url+"/user",UsuarioDto[].class);
        return Arrays.asList(response);
    }

    public void saveUser(UsuarioDto user){

        restTemplate.postForObject(url+"/user",user,UsuarioDto.class);
    }

    public void updateUser(Integer id,UsuarioDto user){

        restTemplate.put(url+"/user/"+id,user);
    }

    public void deleteUser(Integer id){
restTemplate.delete(url+"/user/"+id);
    }
}
