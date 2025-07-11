package org.example.playground;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountRepository extends JpaRepository<People_count, Long> {
    People_count findTopByOrderByIdDesc();
}
