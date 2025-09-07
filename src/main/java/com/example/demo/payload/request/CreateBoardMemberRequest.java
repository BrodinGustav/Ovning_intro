package com.example.demo.payload.request;

public record CreateBoardMemberRequest
        (
                String name,
                String adress,
                String email,
                int phoneNumber
        )
{}
