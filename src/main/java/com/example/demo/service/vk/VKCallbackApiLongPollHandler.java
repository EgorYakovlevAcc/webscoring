package com.example.demo.service.vk;

import com.vk.api.sdk.callback.longpoll.CallbackApiLongPoll;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.objects.wall.WallPost;

public class VKCallbackApiLongPollHandler extends CallbackApiLongPoll {
    public VKCallbackApiLongPollHandler(VkApiClient client, UserActor actor, Integer groupId) {
        super(client, actor, groupId);
    }

    public VKCallbackApiLongPollHandler(VkApiClient client, UserActor actor, int groupId) {
        super(client, actor, groupId);
    }

    public VKCallbackApiLongPollHandler(VkApiClient client, GroupActor actor) {
        super(client, actor);
    }

    public VKCallbackApiLongPollHandler(VkApiClient client, UserActor actor, int groupId, int waitTime) {
        super(client, actor, groupId, waitTime);
    }

    public VKCallbackApiLongPollHandler(VkApiClient client, GroupActor actor, int waitTime) {
        super(client, actor, waitTime);
    }
    public void messageNew(Integer groupId, Message message) {
        System.out.println("messageNew: " + message.toString());
    }

    public void wallPostNew(Integer groupId, WallPost wallPost) {
        System.out.println("wallPostNew: " + wallPost.toString());
    }
}