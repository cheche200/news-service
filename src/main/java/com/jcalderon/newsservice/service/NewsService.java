package com.jcalderon.newsservice.service;

import com.jcalderon.newsservice.model.NewsCategory;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import com.jcalderon.newsservice.model.NewsArticle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class NewsService {

    private static final int MIN_WEIGHT = 1;
    private static final int MAX_WEIGHT = 20;
    private final Lorem lorem = LoremIpsum.getInstance();

    public List<NewsArticle> getNews() {
        return List.of(generateRandomNews(),
                generateRandomNews(),
                generateRandomNews(),
                generateRandomNews(),
                generateRandomNews(),
                generateRandomNews(),
                generateRandomNews());
    }

    private NewsArticle generateRandomNews(){
        return NewsArticle.builder().
                id(UUID.randomUUID().toString()).
                category(NewsCategory.randomCategory()).
                title(lorem.getTitle(2, 6)).
                description(lorem.getWords(3, 20)).
                tags(List.of(getRandomTag(), getRandomTag())).
                weight(getRandomWeighting()).
                build();
    }

    private int getRandomWeighting() {
        return ThreadLocalRandom.current().nextInt(MIN_WEIGHT, MAX_WEIGHT + 1);
    }

    private String getRandomTag() {
        return lorem.getWords(1);
    }
}
