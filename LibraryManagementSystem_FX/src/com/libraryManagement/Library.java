package com.libraryManagement;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Library {

    private String title;
    private String author;
    private String type;

    public Library(String title, String author, String type) {
        this.title = title;
        this.author = author;
        this.type = type;
    }


    public String getTitle() {
        return title;
    }

   
    public String getAuthor() {
        return author;
    }


    public String getType() {
        return type;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public void setType(String type) {
        this.type = type;
    }


    public StringProperty titleProperty() {
        return new SimpleStringProperty(title);
    }

    public StringProperty authorProperty() {
        return new SimpleStringProperty(author);
    }

 
    public StringProperty typeProperty() {
        return new SimpleStringProperty(type);
    }
}