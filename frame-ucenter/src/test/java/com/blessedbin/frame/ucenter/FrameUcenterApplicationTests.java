package com.blessedbin.frame.ucenter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.models.Swagger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.service.Documentation;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * Created by xubin on 2018/7/29.
 *
 * @author 37075
 * @date 2018/7/29
 * @time 15:24
 * @tool intellij idea
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class FrameUcenterApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ServerProperties serverProperties;

    @Autowired
    private DocumentationCache documentationCache;

    @Autowired
    private ServiceModelToSwagger2Mapper mapper;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void scanApiTest() throws JsonProcessingException {

        Documentation documentation = documentationCache.documentationByGroup(Docket.DEFAULT_GROUP_NAME);
        Swagger swagger = mapper.mapDocumentation(documentation);

        System.out.println(objectMapper.writeValueAsString(swagger));
    }




}
