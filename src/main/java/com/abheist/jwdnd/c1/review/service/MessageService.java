package com.abheist.jwdnd.c1.review.service;

import com.abheist.jwdnd.c1.review.model.ChatForm;
import com.abheist.jwdnd.c1.review.model.ChatMessage;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageService {
    private List<ChatMessage> chatMessages;

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
        this.chatMessages = new ArrayList<>();
    }

    public void addMessage(ChatForm chatForm) {
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType()) {
            case "Say":
                newMessage.setMessage(chatForm.getMessageText());
                break;
            case "Shout":
                newMessage.setMessage(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                newMessage.setMessage(chatForm.getMessageText().toLowerCase());
                break;
        }
        this.chatMessages.add(newMessage);
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }

}
