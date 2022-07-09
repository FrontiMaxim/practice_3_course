package com.example.demo.controllers;

import com.example.demo.mappers.Ed807Mapper;
import com.example.demo.mappers.FileMapper;
import com.example.demo.models.Ed807;
import com.example.demo.models.File;
import com.example.demo.services.FileService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }


    @RequestMapping (path = "/file", method = RequestMethod.POST)
    public void postFile(@RequestBody String dataString) {
        JSONObject dataJSON = fileService.parsingStringtoJSON(dataString);
        FileMapper parseFileMapper = fileService.deserializationJson(dataJSON);
        fileService.saveDatabase(parseFileMapper);
    }

    @RequestMapping (path = "/file/{id}", method = RequestMethod.GET)
    public File getFile(@PathVariable(value = "id") Long id) {
        return fileService.getFile(id);
    }
}
