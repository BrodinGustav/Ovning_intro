package com.example.demo.service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.mapper.MemberMapper;
import com.example.demo.payload.request.CreateMemberRequest;
import com.example.demo.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.demo.models.Member;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public MemberDTO createMember(CreateMemberRequest req){
        Member member = memberMapper.fromCreateMemberRequest(req);

        Member savedMember = memberRepository.save(member);
        return memberMapper.toDTO(savedMember);
    }

    //Hämta användare via email
    public MemberDTO findByEmail(String email) {
        return memberRepository.findByEmail(email)
        .map(memberMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Email not found."));
    }

    public Member findByName(String name) {
        return memberRepository.findByName(name);
    }
}
