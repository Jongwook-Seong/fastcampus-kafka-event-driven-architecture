package com.fastcampus.kafkahandson.ugc;

import com.fastcampus.kafkahandson.ugc.port.PostPort;
import com.fastcampus.kafkahandson.ugc.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostCreateService implements PostCreateUsecase {

    private final PostPort postPort;

    @Override
    public Post create(Request request) {
        return Post.generate(
                request.getUserId(),
                request.getTitle(),
                request.getContent(),
                request.getCategoryId()
        );
    }
}
