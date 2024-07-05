package com.fastcampus.kafkahandson.ugc.subscribingpost;

import com.fastcampus.kafkahandson.ugc.post.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collation = "subscribingInboxPosts")
@Data
@AllArgsConstructor
public class SubscribingPostDocument {

    @Id
    private String id; // postId와 followerUserId의 조합
    private Long postId;
    private Long followerUserId;
    private LocalDateTime postCreatedAt;
    private LocalDateTime addedAt; // follower 유저의 구독 목록에 반영된 시점
    private boolean read; // 해당 구독 컨텐츠 조회 여부

    public static SubscribingPostDocument generate(Post post, Long followerUserId) {
        return new SubscribingPostDocument(
                generateDocumentId(post.getId(), followerUserId),
                post.getId(), followerUserId, post.getCreatedAt(), LocalDateTime.now(), false);
    }

    private static String generateDocumentId(Long postId, Long followerUserId) {
        return postId + "_" + followerUserId;
    }
}
