package com.example.demo.repository;

import com.example.demo.models.File;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface FileRepository extends CrudRepository<File, Long> {

    @Query(value = "select * from public.file", nativeQuery = true)
    public String[] findAllFiles();
}
