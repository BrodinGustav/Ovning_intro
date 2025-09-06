package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private long UUID;

    private String name;
    private String adress;
    private String email;
    private int phoneNumber;

}
