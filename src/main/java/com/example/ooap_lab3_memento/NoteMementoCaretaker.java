package com.example.ooap_lab3_memento;

import java.util.HashMap;
import java.util.Map;

public class NoteMementoCaretaker {
    private Map<String, Memento> savedStates = new HashMap<>();

    public void saveState(String title, Memento memento) {
        savedStates.put(title, memento);
    }

    public Memento getState(String title) {
        return savedStates.get(title);
    }
}
