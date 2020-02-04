package com.example.demo.service.vk;

import com.example.demo.model.vk.VKPostDto;
import com.example.demo.repo.VkPostDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VKPostDtoServiceImpl implements VKPostDtoService {
    @Autowired
    private VkPostDtoRepository vkPostDtoRepository;

    @Override
    public VKPostDto findVKPostDtoById(Integer id) {
        return vkPostDtoRepository.findVKPostDtoById(id);
    }

    @Override
    public List<VKPostDto> findAll() {
        return vkPostDtoRepository.findAll();
    }

    @Override
    public void delete(VKPostDto vkPostDto) {
        vkPostDtoRepository.delete(vkPostDto);
    }

    @Override
    public void save(VKPostDto vkPostDto) {
        vkPostDtoRepository.save(vkPostDto);
    }
}
