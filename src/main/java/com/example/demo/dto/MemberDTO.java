package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private Long id;

    private String name;
    private String adress;
    private String email;
    private int phoneNumber;

}
