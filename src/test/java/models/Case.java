package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Case {
    private String title;
    private String status;
    private String description;
//    private String Priority;
//    private String Type;
//    private String Layer;
//    private String IsFlaky;
//    private String Behavior;
//    private String AutomationStatus;
//    private String Preconditions;
}