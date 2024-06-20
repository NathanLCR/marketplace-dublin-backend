package com.nathanlcr.MarketplaceDublin.service.Dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserDto implements Serializable {

    private Integer id;

    private String fullName;

    private String password;

    private String email;

    private String cellphoneNumber;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
