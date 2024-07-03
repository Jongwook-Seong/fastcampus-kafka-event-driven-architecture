package com.fastcampus.kafkahandson.ugc;

import com.fastcampus.kafkahandson.ugc.port.PostPort;
import com.fastcampus.kafkahandson.ugc.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostDeleteService implements PostDeleteUsecase {

    private final PostPort postPort;

    @Override
    public Post delete(Request request) {
        Post post = postPort.findById(request.getPostId());
        if (post == null) return null;
        post.delete();
        return postPort.save(post);
    }
}
