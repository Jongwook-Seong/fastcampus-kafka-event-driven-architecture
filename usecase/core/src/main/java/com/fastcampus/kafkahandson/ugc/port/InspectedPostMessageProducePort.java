package com.fastcampus.kafkahandson.ugc.port;

import com.fastcampus.kafkahandson.ugc.inspectedpost.InspectedPost;
import com.fastcampus.kafkahandson.ugc.post.model.Post;

public interface InspectedPostMessageProducePort {

    void sendCreateMessage(InspectedPost inspectedPost);
    void sendUpdateMessage(InspectedPost inspectedPost);
    void sendDeleteMesssage(Long postId);
}
