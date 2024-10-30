package com.example.prjjsp2.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Member {
    public String id;
    public String password;
    public String nickName;
    public String description;
    private LocalDateTime inserted;
}
