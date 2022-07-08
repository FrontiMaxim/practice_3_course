package com.example.demo.repository;

import com.example.demo.models.AccountStatus;
import org.springframework.data.repository.CrudRepository;

public interface AccountStatusRepository extends CrudRepository <AccountStatus, Long> {
}
