package com.fastcampus.kafkahandson.ugc.inspectedpost;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutoInspectionResult {

    private String status;
    private String[] tags;
}
