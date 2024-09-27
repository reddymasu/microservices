package com.mahesh.contoller;


import com.mahesh.model.MovieInfoRepository;
import com.mahesh.model.Movieinfo;
import com.netflix.discovery.converters.Auto;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieInfoRepository movieInfoRepository;


    @PostMapping("/movie-info/save")
    public List<Movieinfo> saveAll(@RequestBody List<Movieinfo> movieinfoList)
    {
        return movieInfoRepository.saveAll(movieinfoList);
    }

    @GetMapping("/movie-info/list")
    public List<Movieinfo> getAll() {
        return movieInfoRepository.findAll();
    }

    @GetMapping("/movie-info/find-path-by-id/{movieInfoId}")
    public String findPathById(@PathVariable Long movieInfoId)
    {
        var videoInfoOptional =movieInfoRepository.findById(movieInfoId);
        return videoInfoOptional.map(movieinfo -> movieinfo.getPath()).orElse(null);
    }

}
