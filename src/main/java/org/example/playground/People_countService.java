package org.example.playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class People_countService {
     @Autowired
     private CountRepository repository;

    public void updateCount() {
        People_count count = repository.findTopByOrderByIdDesc();
        count.incrementCount();
        repository.save(count);
    }

    public int getCount() {
        return repository.findTopByOrderByIdDesc().getCount();
    }

    public void nextCount() {
        People_count newRecord = new People_count();
        repository.save(newRecord);
    }
}