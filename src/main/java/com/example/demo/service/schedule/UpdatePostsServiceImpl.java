package com.example.demo.service.schedule;

import com.example.demo.service.VKPostDtoService;
import com.example.demo.service.VKService;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@EnableAsync
public class UpdatePostsServiceImpl implements UpdatePostsService {
    @Autowired
    private VKService vkService;
    private Logger LOGGER = LoggerFactory.getLogger(UpdatePostsServiceImpl.class);

    @Async
    @Scheduled(fixedRate = 1000)
    public void updateListOfPosts() throws ClientException, ApiException, IOException {
        vkService.loadPosts();
    }
}
