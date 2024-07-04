package com.fastcampus.kafkahandson.ugc.chatgpt;

import com.fastcampus.kafkahandson.ugc.CustomObjectMapper;
import com.fastcampus.kafkahandson.ugc.chatgpt.model.ChatCompletionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Component
public class ChatGptClient {

    @Value("${OPENAI_API_KEY}")
    private String openaiApiKey;
    private static final String TARGET_GPT_MODEL = "gpt-3.5-turbo";
    private final WebClient chatGptWebClient;
    private final CustomObjectMapper objectMapper = new CustomObjectMapper();

    public ChatGptClient(@Qualifier("chatGptWebClient") WebClient chatGptWebClient) {
        this.chatGptWebClient = chatGptWebClient;
    }

    public String testChatGpt(String content) {
        String jsonString = chatGptWebClient
                .post()
                .uri("/v1/chat/completions")
                .header("Authorization", "Bearer " + openaiApiKey)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(Map.of(
                        "model", TARGET_GPT_MODEL,
                        "messages", List.of(
                                Map.of("role", "system", "content", "You are an assistant."),
                                Map.of("role", "user", "content", content)),
                        "stream", false))
                .retrieve()
                .bodyToMono(String.class)
                .block();
        try {
            ChatCompletionResponse response = objectMapper.readValue(jsonString, ChatCompletionResponse.class);
            return response.getChoices()[0].getMessage().getContent();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
