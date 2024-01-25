package com.rimhassani.confirmerCommande.listener;

import com.rimhassani.confirmerCommande.events.NewOrderEvent;
import com.rimhassani.confirmerCommande.model.CommandeEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Component
public class OrderEventListener {

    @Value("${whatsapp.api.base-url}")
    private String whatsappApiBaseUrl;

    @Value("${whatsapp.api.phone-number-id}")
    private String phoneNumberId;

    @Value("${whatsapp.api.bearer-token}")
    private String bearerToken;

    @EventListener
    public void handleNewOrderEvent(NewOrderEvent newOrderEvent) {
        // Logique pour gérer l'événement de nouvelle commande
        // Par exemple, obtenir les détails de la commande
        CommandeEntity nouvelleCommande = (CommandeEntity) newOrderEvent.getSource();

        // Envoyer le message WhatsApp
        envoyerMessageWhatsApp(nouvelleCommande.getClient().getClientPhoneNumber());
    }

    private void envoyerMessageWhatsApp(String toPhoneNumber) {
        try {
            // Build URI with parameters
            URI uri = new URI("https://graph.facebook.com/v18.0/220513921143313/messages");

            // Build HTTP request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Authorization", "Bearer EAANWHadNxR8BO64ZAYsi9JNBXUdb82rbzMpWfJFkZBhgTkUcDoIoN32eL6SHbmV1ZCPzCUuqvq2TXmWKhxX3qwm4PTB8ZARw49eT88uLPY33f6Jjh1WEtuXUQ2gPWXOvKGKK6oGpjKUydNOi4m7LnjQpz95xn9ORfSXXlKv3ciORL0ZBTFZCW9nPP1oGivPtVEmdkMeE59s62C2RK0p5cH")
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString("{ \"messaging_product\": \"whatsapp\", \"to\": \"+212606581004\", \"type\": \"template\", \"template\": { \"name\": \"hello_world\", \"language\": { \"code\": \"en_US\" } } }"))
                    .build();

            // Initialize HTTP client
            HttpClient http = HttpClient.newHttpClient();

            // Send the request and get the response
            HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());

            // Display the response in the console
            System.out.println(response.body());

        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}