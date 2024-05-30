package com.example.ooap_lab3_memento;


import java.time.LocalDateTime;

public class Memento {
    private final String title;
    private final String content;
    private final LocalDateTime dateTime;

    public Memento(String title, String content, LocalDateTime dateTime) {
        this.title = title;
        this.content = content;
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return title + " (" + dateTime.toString() + ")";
    }
}