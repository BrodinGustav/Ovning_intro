package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import com.example.demo.payload.request.CreateMemberRequest;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //Hämta alla members
    @GetMapping
    public ResponseEntity<List<MemberDTO>> getAllMembers() {
        List<MemberDTO> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    //Hämta members via email
    @GetMapping("/email")
    public ResponseEntity<MemberDTO> getMemberByEmail(@RequestParam String email) {
       MemberDTO member = memberService.findByEmail(email);

       if(member == null) {
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(member);
    }

    //Hämta members via name
    @GetMapping("/name")
    public ResponseEntity<MemberDTO> getMemberByName(@RequestParam String name) {
        MemberDTO member = memberService.findByName(name);

        if(member == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(member);
    }

    //Skapa member
    @PostMapping("/create")
    public ResponseEntity<MemberDTO> createMember(@RequestBody CreateMemberRequest req) {
        MemberDTO createdMember = memberService.createMember(req);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdMember);
    }

    //Uppdatera member
    @PutMapping("/update/{id}")
    public ResponseEntity<MemberDTO> updateMember(@PathVariable Long Id, @RequestBody CreateMemberRequest member) {
        MemberDTO updatedMember = memberService.updateMember(Id, member);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedMember);
    }

    //Radera member
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {

        boolean deleted = memberService.deleteMember(id);

        if(!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
