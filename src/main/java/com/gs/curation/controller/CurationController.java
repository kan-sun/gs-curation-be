package com.gs.curation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gs.curation.domain.CurationResponse;
import com.gs.curation.domain.Response;
import com.gs.curation.domain.ResponseHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@RestController
public class CurationController {

    private final ObjectMapper mapper;
    private final ResourceLoader resourceLoader;
    private final Optional<CurationResponse> data;
    private static final Logger LOGGER = LoggerFactory.getLogger(CurationController.class);

    @Autowired
    public CurationController(ObjectMapper mapper, ResourceLoader resourceLoader) {
        this.mapper = mapper;
        this.resourceLoader = resourceLoader;
        this.data = Optional.of(loadFromFile());
    }

    @RequestMapping("/get/responses")
    public CurationResponse getCurationResponse() throws IOException {
        CurationResponse curationResponse = data.orElseGet(()-> loadFromFile());
        return curationResponse;
    }

    private CurationResponse loadFromFile() {
        try {
            final Resource resource = resourceLoader.getResource("classpath:Documents.json");
            final InputStream inputStream = resource.getInputStream();
            return mapper.readValue(inputStream, CurationResponse.class);
        } catch (IOException e) {
            LOGGER.error("Error in reading from the local json file. An empty will be returned.", e);
            return new CurationResponse(ResponseHeader.newBuilder().build(), Response.newBuilder().build());
        }
    }
}
