package com.example.demo.repo;

import com.example.demo.model.vk.VKPostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VkPostDtoRepository extends JpaRepository<VKPostDto, Integer> {
    VKPostDto findVKPostDtoById(Integer id);
    List<VKPostDto> findAll ();
}
