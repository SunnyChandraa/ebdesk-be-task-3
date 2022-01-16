package com.demo.ebdeskbetask3.services.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "yt_trending")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class YoutubeVideo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "channel_id", nullable = false)
    private String channelId;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "channel_name", nullable = false)
    private String channelName;

    @Column(name = "published_at", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date publishedAt;

}
