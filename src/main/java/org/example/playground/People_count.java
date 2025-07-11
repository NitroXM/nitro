package org.example.playground;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class People_count {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int count;

    public void incrementCount() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public long getId() {
        return id;
    }
}
