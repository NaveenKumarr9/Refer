package com.student.exception;

import lombok.*;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDetails {


    private Date timestamp;
    private String message;
    private String details;

}
