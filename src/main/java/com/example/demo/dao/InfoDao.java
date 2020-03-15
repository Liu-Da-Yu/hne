package com.example.demo.dao;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class InfoDao {

    private String uuid;
    private String nameInput ;
    private String companyInput ;
    private String contactInput ;
    private String emailInput ;
    private String messageInput ;
    private Date date ;

    public InfoDao() {

    }

    public InfoDao(String uuid, String nameInput, String companyInput, String contactInput, String emailInput, String messageInput, Date date) {
        this.uuid = uuid;
        this.nameInput = nameInput;
        this.companyInput = companyInput;
        this.contactInput = contactInput;
        this.emailInput = emailInput;
        this.messageInput = messageInput;
        this.date = date;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNameInput() {
        return nameInput;
    }

    public void setNameInput(String nameInput) {
        this.nameInput = nameInput;
    }

    public String getCompanyInput() {
        return companyInput;
    }

    public void setCompanyInput(String companyInput) {
        this.companyInput = companyInput;
    }

    public String getContactInput() {
        return contactInput;
    }

    public void setContactInput(String contactInput) {
        this.contactInput = contactInput;
    }

    public String getEmailInput() {
        return emailInput;
    }

    public void setEmailInput(String emailInput) {
        this.emailInput = emailInput;
    }

    public String getMessageInput() {
        return messageInput;
    }

    public void setMessageInput(String messageInput) {
        this.messageInput = messageInput;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
