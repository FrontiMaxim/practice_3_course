package com.example.demo.controllers;

import com.example.demo.mappers.FileMapper;
import com.example.demo.maskes.MaskInfoFile;
import com.example.demo.models.File;
import com.example.demo.services.FileService;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }


    @RequestMapping (path = "/file", method = RequestMethod.POST)
    public String postFile(@RequestBody String dataString) {
        JSONObject dataJSON = fileService.parsingStringtoJSON(dataString);
        FileMapper parseFileMapper = fileService.deserializationJson(dataJSON);
        fileService.saveDatabase(parseFileMapper);
        return "OK";
    }

    @RequestMapping (path = "/file/{id}", method = RequestMethod.GET)
    public File getFile(@PathVariable(value = "id") Long id) {
        return fileService.getFile(id);
    }

    @RequestMapping(path = "/files", method = RequestMethod.GET)
    public ArrayList<MaskInfoFile> getFiles() {
        return fileService.getFiles();
    }
}
