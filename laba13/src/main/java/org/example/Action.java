package org.example;

public enum Action {
    ADDED("добавлена"), REMOVED("удалена");

    private final String description;

    Action(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}