package com.rimhassani.confirmerCommande.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
public class WebHookController {
    @Value("${facebook.webhook.verify-token}")
    private String verifyToken;

    @GetMapping("/webhook")
    public String verifyWebhook(@RequestParam("hub.verify_token") String verifyTokenParam,
                                @RequestParam("hub.challenge") String challenge) {
        if (verifyTokenParam.equals(verifyToken)) {
            return challenge;
        } else {
            return "Invalid Verify Token";
        }
    }

    @PostMapping("/webhook")
    public void handleWebhookEvent(@RequestBody String payload) {
        System.out.println("Incoming webhook event: " + payload);

        // Assuming you have a method to handle WhatsApp messages
        handleWhatsAppMessage(payload);
    }

    // Method to handle WhatsApp messages
    private void handleWhatsAppMessage(String payload) {
        // Print the incoming WhatsApp message payload to the terminal
        System.out.println("Incoming WhatsApp message: " + payload);
    }
}