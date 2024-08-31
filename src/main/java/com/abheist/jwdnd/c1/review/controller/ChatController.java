package com.abheist.jwdnd.c1.review.controller;

import com.abheist.jwdnd.c1.review.model.ChatForm;
import com.abheist.jwdnd.c1.review.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private final MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String getChatPage(ChatForm chatForm, Model model) {
        model.addAttribute("chatMessage", this.messageService.getChatMessages());
        return "chat";
    }

    @PostMapping
    public String postChatMessage(ChatForm chatForm, Model model) {
        this.messageService.addMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("chatMessage", this.messageService.getChatMessages());
        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] addMessageTypes() {
        return new String[]{"Say", "Shout", "Whisper"};
    }

}
