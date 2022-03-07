package com.jcalderon.newsservice.api;

import com.jcalderon.newsservice.model.NewsArticle;
import com.jcalderon.newsservice.service.NewsService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/news")
    @ApiOperation(value = "Returns a random list of news articles",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NewsArticle>> search() {
        log.debug("Requesting news...");
        return ResponseEntity.ok(newsService.getNews());
    }
}
