package com.aluracursos.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {

    public static String obtenerTraduccion(String texto){
        OpenAiService service = new OpenAiService("sk-proj-4jenxWa5136TtcBQf3nRT3BlbkFJFmzxxHn9RvisYErpCnW0");

        CompletionRequest requisicion = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("Traduce en español el siguient text: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();
        var respuesta = service.createCompletion(requisicion);
        return respuesta.getChoices().get(0).getText();

    }
}
