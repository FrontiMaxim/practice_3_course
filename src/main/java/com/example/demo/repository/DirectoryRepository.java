package com.example.demo.repository;

import com.example.demo.models.Directory;
import org.springframework.data.repository.CrudRepository;

public interface DirectoryRepository extends CrudRepository<Directory, Long> {
}
