package com.mang.grh.entities.Administration.Logging;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name ="OperationTrace")
public class OperationTrace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String operation;
    private String entityName;
    private String timestamp;

}
