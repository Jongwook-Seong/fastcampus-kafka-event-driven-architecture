package com.fastcampus.kafkahandson.ugc;

import com.fastcampus.kafkahandson.ugc.port.SubscribingPostPort;
import com.fastcampus.kafkahandson.ugc.post.model.ResolvedPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscribingPostListService implements SubscribingPostListUsecase {

    private final SubscribingPostPort subscribingPostPort;
    private final PostResolvingHelpUsecase postResolvingHelpUsecase;

    private static final int PAGE_SIZE = 5;

    @Override
    public List<ResolvedPost> listSubscribingInboxPosts(Request request) {
        List<Long> subscribingPostIds = subscribingPostPort.listPostIdsByFollowerUserIdWithPagination(
                request.getFollowerUserId(), request.getPageNumber(), PAGE_SIZE);
        return postResolvingHelpUsecase.resolvePostsByIds(subscribingPostIds);
    }
}
