package org.example.playground;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {

    @Autowired
    private People_countService countService;

    @Autowired
    private CountRepository repository;

    @PostMapping("/data")
    public ResponseEntity<String> receiveData() {
        try {
            countService.updateCount();
            return ResponseEntity.ok("Count updated!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/data/save")
    public ResponseEntity<String> saveData() {
    countService.nextCount();
     return ResponseEntity.ok("Count saved!");
    }

    @GetMapping("/data/return")
    public List<Integer> returnData() {
        List<Integer> result = new ArrayList<>();
        List<People_count> allRecords = repository.findAll(Sort.by(Sort.Direction.ASC, "id"));

        for (People_count record : allRecords) {
            result.add(record.getCount());
        }
        return result;
    }
}
