package com.example.demo.service.regex;

import com.example.demo.model.vk.VKPostDto;
import com.example.demo.pojo.Regexes;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RegexServiceImpl implements RegexService {
    private Regexes regexes;
    private static final String FILE_NAME = "src/main/resources/configuration/regexforpredict.json";

    @Override
    public List<VKPostDto> filterPostsWithRegexes(List<VKPostDto> posts) {
        return posts.stream()
                .filter(post -> checkPostWithRegexes(post.getText()))
                .collect(Collectors.toList());
    }

    @Override
    public Regexes updateRegexesForParsing(Regexes regexes) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            regexes = objectMapper.readValue(new File(FILE_NAME), Regexes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return regexes;
    }

    public Regexes getRegexesForParsing() {
        if (Objects.isNull(this.regexes)){
            return updateRegexesForParsing(new Regexes());
        }
        else {
            return this.regexes;
        }
    }

    //check ALL words from dict
    public boolean checkPostWithRegexes(String text){
        List<String> regexesStr = getRegexesForParsing().getRegex();
        for (String regex: regexesStr){
            int index = text.indexOf(regex);
            if (index != -1) {
                return true;
            }
        }
        return false;
    }
}
