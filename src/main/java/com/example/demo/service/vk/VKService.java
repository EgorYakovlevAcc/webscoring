package com.example.demo.service.vk;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;

import java.io.IOException;
import java.util.List;

public interface VKService {
    void loadPosts () throws ClientException, ApiException, IOException;
    List<String> getGroupNames() throws IOException;
}
