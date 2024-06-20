package com.example.stashservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data_item", schema = "public")
public class DataItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stash_key", nullable = false, length = 255)
    private String stashKey;

    @Column(name = "stash_value", nullable = false, length = 255)
    private String stashValue;

    // Getters and setters
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
}
