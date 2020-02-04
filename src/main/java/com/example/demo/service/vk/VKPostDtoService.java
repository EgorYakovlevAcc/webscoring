package com.example.demo.service.vk;

import com.example.demo.model.vk.VKPostDto;

import java.util.List;

public interface VKPostDtoService {
    VKPostDto findVKPostDtoById (Integer id);
    List<VKPostDto> findAll ();
    void delete (VKPostDto vkPostDto);
    void save (VKPostDto vkPostDto);
}
