package com.example.demo.service.vk;

import com.example.demo.model.vk.VKPostDto;
import com.example.demo.pojo.Groups;
import com.example.demo.service.regex.RegexService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.utils.DomainResolved;
import com.vk.api.sdk.objects.wall.WallPostFull;
import com.vk.api.sdk.objects.wall.responses.GetResponse;
import com.vk.api.sdk.queries.utils.UtilsResolveScreenNameQuery;
import com.vk.api.sdk.queries.wall.WallGetQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class VKServiceImpl implements VKService {
    private Logger LOGGER = LoggerFactory.getLogger(VKServiceImpl.class);
    private static final int VK_API_ID = 7253448;
    private static final String VK_SECURE_KEY = "mcQgoqT0QNsxzZPCDm4b";
    private static final String VK_SERVICE_KEY = "fed3591efed3591efed3591e0ffebdf4d6ffed3fed3591ea328c8045ddc94fe9d18449e";
    @Autowired
    private VKPostDtoService vkPostDtoService;
    @Autowired
    private RegexService regexService;

    @Override
    public void loadPosts() throws ClientException, ApiException, IOException {
        LOGGER.info("loadPosts [START]");
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);
        ServiceActor serviceActor = new ServiceActor(VK_API_ID, VK_SECURE_KEY, VK_SERVICE_KEY);
        WallGetQuery wallGetQuery = vk.wall().get(serviceActor);
        for (String name: getGroupNames()) {
            UtilsResolveScreenNameQuery utilsResolveScreenNameQuery =
                    vk.utils().resolveScreenName(serviceActor, name);
            DomainResolved domainResolved = utilsResolveScreenNameQuery.execute();
            wallGetQuery.ownerId(-domainResolved.getObjectId());
            GetResponse getResponse = wallGetQuery.execute();
            List<WallPostFull> listOfPosts = getResponse.getItems();
            for (WallPostFull wallPostFull : listOfPosts) {
                String text = wallPostFull.getText();
                if (regexService.checkPostWithRegexes(text)) {
                    VKPostDto vkPostDto = new VKPostDto();
                    vkPostDto.setText(wallPostFull.getText());
                    vkPostDto.setDate(wallPostFull.getDate());
                    vkPostDtoService.save(vkPostDto);
                }
            }
        }
        LOGGER.info("loadPosts [FINISH]");
    }

    @Override
    public List<String> getGroupNames() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Groups groups = objectMapper.readValue(new File("src/main/resources/configuration/groups.json"), Groups.class);
        return groups.getNames();
    }
}
