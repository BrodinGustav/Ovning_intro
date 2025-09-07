package com.example.demo.controller;

import com.example.demo.dto.BoardMemberDTO;
import com.example.demo.payload.request.CreateBoardMemberRequest;
import com.example.demo.service.BoardMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boardMembers")
@RequiredArgsConstructor
public class BoardMemberController {

    private final BoardMemberService boardMemberService;

    //Hämta alla boardmembers
    @GetMapping
    public ResponseEntity<List<BoardMemberDTO>> getAllBoardMembers() {
        List<BoardMemberDTO> boardMembers = boardMemberService.findAllBoardMembers();

        if(boardMembers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(boardMembers);
    }

    //Hämtar boardmember via ID
    @GetMapping("/{id}")
    public ResponseEntity<BoardMemberDTO> getBoardMemberById(@PathVariable Long id) {
        BoardMemberDTO boardMember = boardMemberService.findBoardMemberById(id);

        if(boardMember == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(boardMember);
    }

    //Skapa boardmember
    @PostMapping("/create")
    public ResponseEntity<BoardMemberDTO> createBoardMember(@RequestBody CreateBoardMemberRequest req) {
        BoardMemberDTO boardMember = boardMemberService.createBoardMember(req);

        return ResponseEntity.status(HttpStatus.CREATED).body(boardMember);
    }

    //Uppdatera boardmember
    @PutMapping("/update/{id}")
    public ResponseEntity<BoardMemberDTO> updateBoardMember(@PathVariable Long id, @RequestBody CreateBoardMemberRequest req) {
        BoardMemberDTO updatedBoardMember = boardMemberService.updateBoardMemberById(id, req);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedBoardMember);
    }

    //Radera boardmember
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBoardMember(@PathVariable Long id) {
        boolean deleted = boardMemberService.deleteBoardMemberById(id);

        if(!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
