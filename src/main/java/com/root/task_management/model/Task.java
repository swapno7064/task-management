package com.root.task_management.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "tasks")
public class Task {

    @Id
    private String id;
    private String title;
    private String description;
    private String status;
    private String createdBy;
    private String assignedTo;
    private Date createdAt;
    private Date updatedAt;
}
