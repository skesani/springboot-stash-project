package com.example.stashclient.model;

public class StashDataItem {
    private Long id;
    private String stashKey;
    private String stashValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStashKey() {
        return stashKey;
    }

    public void setStashKey(String stashKey) {
        this.stashKey = stashKey;
    }

    public String getStashValue() {
        return stashValue;
    }

    public void setStashValue(String stashValue) {
        this.stashValue = stashValue;
    }

    public StashDataItem() {
    }
}
