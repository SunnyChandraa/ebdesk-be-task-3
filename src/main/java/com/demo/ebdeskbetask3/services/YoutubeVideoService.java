package com.demo.ebdeskbetask3.services;

import com.demo.ebdeskbetask3.services.entities.YoutubeVideo;
import com.demo.ebdeskbetask3.repository.YoutubeVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class YoutubeVideoService {

    private final YoutubeVideoRepository youtubeVideoRepository;

    @Autowired
    public YoutubeVideoService(YoutubeVideoRepository youtubeVideoRepository) {
        this.youtubeVideoRepository = youtubeVideoRepository;
    }

    public List<YoutubeVideo> getYoutubeVideos() { return youtubeVideoRepository.findByOrderByPublishedAtDesc(); }

    public void addNewYoutubeVideo(YoutubeVideo youtubeVideo) {
        Optional<YoutubeVideo> youtubeVideoByTitle = youtubeVideoRepository.findVideoByTitle(youtubeVideo.getTitle());
        if (youtubeVideoByTitle.isPresent()) {
            throw new IllegalStateException("Title already exist");
        }
        youtubeVideoRepository.save(youtubeVideo);
    }

    public void deleteYoutubeVideoById(Integer id) {
        boolean isExist = youtubeVideoRepository.existsById(id);
        if (!isExist) {
            throw new IllegalStateException(String.format("Youtube video data with id %s is not exist", id));
        }
        youtubeVideoRepository.deleteById(id);
    }

    @Transactional
    public void updateYoutubeVideoById(Integer id,
                                       String channelId,
                                       String title,
                                       String channelName,
                                       Date publishedAt) {

        YoutubeVideo youtubeVideo = youtubeVideoRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(String.format("Youtube video data with id %s is not exist", id)));

        if (channelId != null
                && channelId.length() > 0
                && !Objects.equals(youtubeVideo.getChannelId(), channelId)) {
            youtubeVideo.setChannelId(channelId);
        }

        if (title != null
                && title.length() > 0
                && !Objects.equals(youtubeVideo.getTitle(), title)) {
            Optional<YoutubeVideo> youtubeVideoByTitle = youtubeVideoRepository.findVideoByTitle(title);
            if (youtubeVideoByTitle.isPresent()) {
                throw new IllegalStateException("Title already exist");
            }
            youtubeVideo.setTitle(title);
        }

        if (channelName != null
                && channelName.length() > 0
                && !Objects.equals(youtubeVideo.getChannelName(), channelName)) {
            youtubeVideo.setChannelName(channelName);
        }

        if (publishedAt != null
                && !Objects.equals(youtubeVideo.getPublishedAt(), publishedAt)) {
            youtubeVideo.setPublishedAt(publishedAt);
        }

    }
}
