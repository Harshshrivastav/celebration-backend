package com.eventsystemManagement.eventmanagement.repository;

import java.time.LocalDate;
import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eventsystemManagement.eventmanagement.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
	
	List<Event> findByUserId(Long userId);

    @Query("SELECT e FROM Event e WHERE " +
            "(:category IS NULL OR e.category = :category) AND " +
            "(:location IS NULL OR e.location = :location) AND " +
            "(:date IS NULL OR e.date = :date)")
    Page<Event> findAllByFilters(@Param("category") String category,
                                 @Param("location") String location,
                                 @Param("date") LocalDate date,
                                 Pageable pageable);
}