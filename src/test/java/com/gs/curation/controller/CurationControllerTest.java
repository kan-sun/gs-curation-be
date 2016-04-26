package com.gs.curation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by kansun on 26/04/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class CurationControllerTest {

    private MockMvc mockMvc;

    private CurationController target;

    private ResourceLoader resourceLoader;

    @Before
    public void setup() {
        ObjectMapper mapper = new ObjectMapper();
        resourceLoader = new FileSystemResourceLoader();
        this.target = new CurationController(mapper, resourceLoader);
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.target).build();
    }

    @Test
    public void shouldReturnJsonWhenServiceReturnsNonEmptyOptional() throws Exception {

        this.mockMvc.perform(get(String.format("/get/responses"))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.responseHeader").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.response").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.numFound").value(61))
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.docs", hasSize(61)))
        ;
    }

}