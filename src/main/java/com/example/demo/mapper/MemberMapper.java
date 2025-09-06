package com.example.demo.mapper;

import com.example.demo.dto.MemberDTO;
import com.example.demo.models.Member;
import com.example.demo.payload.request.CreateMemberRequest;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public Member fromCreateMemberRequest(CreateMemberRequest req) {
        Member member = new Member();

        member.setName(req.name());
        member.setEmail(req.email());
        member.setAdress(req.adress());
        member.setPhoneNumber(req.phoneNumber());

        return member;
    }

    public MemberDTO toDTO (Member member) {

        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setName(member.getName());
        memberDTO.setEmail(member.getEmail());
        memberDTO.setAdress(member.getAdress());
        memberDTO.setPhoneNumber(member.getPhoneNumber());
        return memberDTO;
    }

    public Member toEntity(MemberDTO memberDTO) {
        Member entity = new Member();
        entity.setName(memberDTO.getName());
        entity.setEmail(memberDTO.getEmail());
        entity.setAdress(memberDTO.getAdress());
        entity.setPhoneNumber(memberDTO.getPhoneNumber());
        return entity;
    }
}
