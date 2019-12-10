package com.example.vertical.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clients")
public class Client {
    public Client(String clientName, String clientEmail, String clientNumber, String clientText) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.clientNumber = clientNumber;
        this.clientText = clientText;
    }
    @Id
    private String id;
    String clientName;
    String clientEmail;
    String clientNumber;
    String clientText;

    public String getClientName() {
        return clientName;
    }
    public void getClientName(String clientName) {this.clientName = clientName;}

    public String getClientEmail() {
        return clientEmail;
    }
    public void getClientEmail(String clientEmail) {this.clientEmail = clientEmail;}

    public String getClientNumber() {
        return clientNumber;
    }
    public void getClientNumber(String clientNumber) {this.clientNumber = clientNumber;}

    public String getClientText() {
        return clientText;
    }
    public void getClientText(String clientText) {this.clientText = clientText;}


}
