package com.greenfox.p2pchat;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = P2pchatApplication.class)
@WebAppConfiguration
@EnableWebMvc
public class P2pchatApplicationTests {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void successfulMessageReceiving() throws Exception {
        JSONObject message = new JSONObject();

        message.put("id", new Integer(7655482));
        message.put("username", "EggDice");
        message.put("text", "How you doin'?");
        message.put("timestamp", Long.valueOf("1322018752992"));

        JSONObject client = new JSONObject();

        client.put("id", "EggDice");

        JSONObject wrapper = new JSONObject();
        wrapper.put("message", message);
        wrapper.put("client", client);

        mockMvc.perform(post("/api/message/receive")
                .contentType(MediaType.APPLICATION_JSON)
                .content(wrapper.toString()))
                .andExpect(status().isOk());
    }

    @Test
    public void unsuccessfulMessageReceiving() throws Exception {
        JSONObject message = new JSONObject();

        message.put("id", new Integer(7655482));
        message.put("username", "EggDice");
        message.put("text", null);
        message.put("timestamp", Long.valueOf("1322018752992"));

        JSONObject client = new JSONObject();

        client.put("id", "EggDice");

        JSONObject wrapper = new JSONObject();
        wrapper.put("message", message);
        wrapper.put("client", client);

        mockMvc.perform(post("/api/message/receive")
                .contentType(MediaType.APPLICATION_JSON)
                .content(wrapper.toString()))
                .andExpect(status().is4xxClientError());
    }
}