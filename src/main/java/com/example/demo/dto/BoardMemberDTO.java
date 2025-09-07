package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardMemberDTO {
    private Long id;
    private String name;
    private String email;
    private String address;
    private int phoneNumber;
}
