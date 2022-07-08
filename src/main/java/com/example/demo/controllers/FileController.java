package com.example.demo.controllers;

import com.example.demo.mappers.Ed807Mapper;
import com.example.demo.services.FileService;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }


    @RequestMapping (path = "/file", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public void postFile(@RequestBody String data) {
        JSONObject dataJSON = fileService.parsingStringtoJSON(data);
        Ed807Mapper parseED807 = fileService.deserializationJson(dataJSON);
        fileService.saveDatabase(parseED807);
    }
}
