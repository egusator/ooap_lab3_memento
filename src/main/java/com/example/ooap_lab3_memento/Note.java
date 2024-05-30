package com.example.ooap_lab3_memento;


import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;

public class Note {
    private String title;
    private String content;
    private LocalDateTime dateTime;

    public Note() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Memento save() {
        this.dateTime = LocalDateTime.now();
        return new Memento(title, content, dateTime);
    }

    public void restore(Memento memento) {
        this.title = memento.getTitle();
        this.content = memento.getContent();
        this.dateTime = memento.getDateTime();
    }
}