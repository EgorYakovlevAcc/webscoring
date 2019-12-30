package com.example.demo.service.schedule;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;

import java.io.IOException;

public interface UpdatePostsService {
    void updateListOfPosts() throws ClientException, ApiException, IOException;
}
