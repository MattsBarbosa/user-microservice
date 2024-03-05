package com.ms.user.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@Component
public class EmailDto {

    private UUID userId;
    private String emailTo;
    private String subject;
    private String text;

}
