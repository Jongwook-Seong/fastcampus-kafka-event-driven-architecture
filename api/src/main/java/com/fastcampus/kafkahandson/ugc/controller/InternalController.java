package com.fastcampus.kafkahandson.ugc.controller;

import com.fastcampus.kafkahandson.ugc.PostInspectUsecase;
import com.fastcampus.kafkahandson.ugc.inspectedpost.InspectedPost;
import com.fastcampus.kafkahandson.ugc.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/internal")
public class InternalController {

    private final PostInspectUsecase postInspectUsecase;

    @GetMapping
    InspectedPost inspectedPost(@RequestParam("title") String title,
                                @RequestParam("content") String content,
                                @RequestParam("categoryId") Long categoryId) {
        return postInspectUsecase.inspectAndGetIfValid(
                Post.generate(0L, title, content, categoryId));
    }
}
