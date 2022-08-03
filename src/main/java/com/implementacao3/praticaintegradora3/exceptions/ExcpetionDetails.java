package com.implementacao3.praticaintegradora3.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExcpetionDetails {
    private String title;
    private int status;
    private String fields;
    private String message;
}
