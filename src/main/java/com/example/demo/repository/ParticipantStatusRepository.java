package com.example.demo.repository;

import com.example.demo.models.ParticipantStatus;
import org.springframework.data.repository.CrudRepository;

public interface ParticipantStatusRepository extends CrudRepository<ParticipantStatus, Long> {
}
