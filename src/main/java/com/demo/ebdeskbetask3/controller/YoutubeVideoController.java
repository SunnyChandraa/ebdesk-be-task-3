package com.demo.ebdeskbetask3.controller;

import com.demo.ebdeskbetask3.services.entities.YoutubeVideo;
import com.demo.ebdeskbetask3.services.YoutubeVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/youtube-trending")
public class YoutubeVideoController {

    private final YoutubeVideoService youtubeVideoService;

    @Autowired
    public YoutubeVideoController(YoutubeVideoService youtubeVideoService) {
        this.youtubeVideoService = youtubeVideoService;
    }

    @GetMapping
    public List<YoutubeVideo> getYoutubeVideos() { return youtubeVideoService.getYoutubeVideos(); }

    @PostMapping
    public void addNewYoutubeVideo(@RequestBody YoutubeVideo youtubeVideo) { youtubeVideoService.addNewYoutubeVideo(youtubeVideo); }

    @DeleteMapping(path = "{id}")
    public void deleteYoutubeVideo(@PathVariable("id") Integer id) { youtubeVideoService.deleteYoutubeVideoById(id); }

    @PutMapping(path = "{id}")
    public void updateYoutubeVideo(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) String channelId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String channelTittle,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date publishedAt
    ) {
        youtubeVideoService.updateYoutubeVideoById(id, channelId, title, channelTittle, publishedAt);
    }
}
