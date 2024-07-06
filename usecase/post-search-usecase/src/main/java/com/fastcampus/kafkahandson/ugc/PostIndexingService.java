package com.fastcampus.kafkahandson.ugc;

import com.fastcampus.kafkahandson.ugc.inspectedpost.InspectedPost;
import com.fastcampus.kafkahandson.ugc.port.PostSearchPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostIndexingService implements PostIndexingUsecase {

    private final PostSearchPort postSearchPort;

    @Override
    public void save(InspectedPost post) {
        postSearchPort.indexPost(post);
    }

    @Override
    public void delete(Long postId) {
        postSearchPort.deletePost(postId);
    }
}
