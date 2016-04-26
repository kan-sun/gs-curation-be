package com.gs.curation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gs.curation.domain.CurationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
public class CurationController {

    private final ObjectMapper mapper;
    private final ResourceLoader resourceLoader;

    @Autowired
    public CurationController(ObjectMapper mapper, ResourceLoader resourceLoader) {
        this.mapper = mapper;
        this.resourceLoader = resourceLoader;
    }

    @RequestMapping("/get/responses")
    public CurationResponse getCurationResponse() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:Documents.json");
        File file = resource.getFile();
        CurationResponse curationResponse = mapper.readValue(file, CurationResponse.class);
        return curationResponse;
    }
}
