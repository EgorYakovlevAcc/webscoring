package com.example.demo.controller;

import com.example.demo.model.vk.VKPostDto;
import com.example.demo.service.VKCallbackApiHandler;
import com.example.demo.service.VKPostDtoService;
import com.example.demo.service.VKService;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/vk")
public class VKController {
    @Autowired
    private VKService vkService;
    @Autowired
    private VKPostDtoService vkPostDtoService;

    @ResponseBody
    @GetMapping("/test")
    public String getTest(Model model) throws ClientException, ApiException, IOException {
        vkService.loadPosts();
        return "test for vk api";
    }

    @GetMapping("/all")
    public String getAllPosts(Model model) {
        List<VKPostDto> posts = vkPostDtoService.findAll();
        model.addAttribute("posts", posts);
        return "allposts";
    }

    @GetMapping("/callback")
    @ResponseBody
    public String getCallback(Model model) {
        VKCallbackApiHandler vkCallbackApiHandler = new VKCallbackApiHandler();
        return "callback";
    }
}
