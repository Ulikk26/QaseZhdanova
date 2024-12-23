package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Suite {
    private String suiteName;
    private String parentSuite;
    private String description;
    private String preconditions;
}