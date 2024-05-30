package com.example.ooap_lab3_memento;

import java.util.HashMap;
import java.util.Map;

public class Caretaker {
    private Map<String, Memento> savedStates = new HashMap<>();

    public void saveState(Memento memento) {
        savedStates.put(memento.getDateTime().toString(), memento);
    }

    public Memento getState(String dateTime) {
        return savedStates.get(dateTime);
    }

    public Map<String, Memento> getSavedStates() {
        return savedStates;
    }
}