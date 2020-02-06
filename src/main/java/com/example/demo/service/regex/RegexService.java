package com.example.demo.service.regex;

import com.example.demo.model.vk.VKPostDto;
import com.example.demo.pojo.Regexes;

import java.util.List;

public interface RegexService {
    List<VKPostDto> filterPostsWithRegexes(List<VKPostDto> posts);
    Regexes updateRegexesForParsing(Regexes regexes);
    boolean checkPostWithRegexes(String text);
}
