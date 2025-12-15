package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {

    List<TimeEntry> findByUser(User user);

    List<TimeEntry> findByUserAndDateBetween(User user, LocalDate start, LocalDate end);

    Optional<TimeEntry> findByUserAndClockOutTimeIsNull(User user);
}


