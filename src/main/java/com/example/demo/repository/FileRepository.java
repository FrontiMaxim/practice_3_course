package com.example.demo.repository;

import com.example.demo.models.File;
import org.springframework.data.repository.CrudRepository;

public interface FileRepository extends CrudRepository<File, Long> {
}