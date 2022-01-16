package com.demo.ebdeskbetask3.repository;

import com.demo.ebdeskbetask3.services.entities.YoutubeVideo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface YoutubeVideoRepository extends PagingAndSortingRepository<YoutubeVideo, Integer> {
    List<YoutubeVideo> findByOrderByPublishedAtDesc();
    Optional<YoutubeVideo> findVideoByTitle(String title);
}
