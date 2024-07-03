package com.fastcampus.kafkahandson.ugc;

import com.fastcampus.kafkahandson.ugc.post.model.ResolvedPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostResolvingHelpService implements PostResolvingHelpUsecase {

//    private final PostPort postPort;
    private final MetadataPort metadataPort;

    @Override
    public ResolvedPost resolvePostById(Long postId) {
        return null;
    }

    @Override
    public List<ResolvedPost> resolvePostsByIds(List<Long> postIds) {
        return null;
    }
}
