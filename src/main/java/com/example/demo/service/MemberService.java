package com.example.demo.service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.mapper.MemberMapper;
import com.example.demo.payload.request.CreateMemberRequest;
import com.example.demo.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.demo.models.Member;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    //Skapa medlem
    public MemberDTO createMember(CreateMemberRequest req) {
        System.out.println("Received request: " + req);
        Member member = memberMapper.fromCreateMemberRequest(req);

        Member savedMember = memberRepository.save(member);
        return memberMapper.toDTO(savedMember);
    }

    //Hämta alla medlemmar
    public List<MemberDTO> getAllMembers() {
        List<MemberDTO> members = memberRepository.findAll()
                .stream()
                .map(memberMapper::toDTO)
                .toList();

        return members;
    }

    //Hämta användare via email
    public MemberDTO findByEmail(String email) {
        return memberRepository.findByEmail(email)
                .map(memberMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Email not found."));
    }

    //Hämta medlem via namn
    public MemberDTO findByName(String name) {
        return memberRepository.findByName(name)
                .map(memberMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Name not found."));
    }

    //Uppdatera medlem
    public MemberDTO updateMember (Long id, CreateMemberRequest req) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found."));

        //Uppdatera fält
        member.setPhoneNumber(req.phoneNumber());
        member.setEmail(req.email());
        member.setName(req.name());
        member.setAdress(req.adress());

        memberRepository.save(member);

        return memberMapper.toDTO(member);
    }

    //Radera medlem
    public boolean deleteMember(Long id) {
        if (memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
        }
        return false;
    }
}
