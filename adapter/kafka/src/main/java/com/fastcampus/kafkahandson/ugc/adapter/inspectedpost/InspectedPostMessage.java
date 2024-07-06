package com.fastcampus.kafkahandson.ugc.adapter.inspectedpost;

import com.fastcampus.kafkahandson.ugc.adapter.common.OperationType;
import com.fastcampus.kafkahandson.ugc.inspectedpost.InspectedPost;
import com.fastcampus.kafkahandson.ugc.post.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspectedPostMessage {

    private Long id;
    private Payload payload;
    private OperationType operationType;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Payload {
        private Post post;
        private String categoryName;
        private List<String> autoGeneratedTags;
        private LocalDateTime inspectedAt;
    }

    public InspectedPost toModel() {
        return new InspectedPost(
                this.payload.getPost(),
                this.payload.getCategoryName(),
                this.payload.getAutoGeneratedTags(),
                this.payload.getInspectedAt()
        );
    }
}
