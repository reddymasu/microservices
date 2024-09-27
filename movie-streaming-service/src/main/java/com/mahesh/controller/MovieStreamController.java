package com.mahesh.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RestController
public class MovieStreamController {

    public static final String VIDEO_DIRECTORY ="F:\\stream\\";

    @GetMapping("/stream/{videopath}")
    public ResponseEntity<InputStreamResource> streamVideo(@PathVariable String videopath) throws FileNotFoundException
    {
        File file = new File(VIDEO_DIRECTORY+videopath);
        System.out.println(videopath);
        System.out.println(file.isFile());
        System.out.println(file.getAbsolutePath());


        if(file.exists())
        {
            System.out.println("yes");
            InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("video/mp4"))
                    .body(inputStreamResource);


        }
        else {
            System.out.println("No");
            return ResponseEntity.notFound().build();
        }


    }


}
