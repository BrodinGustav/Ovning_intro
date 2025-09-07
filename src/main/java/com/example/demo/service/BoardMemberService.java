package com.example.demo.service;

import com.example.demo.dto.BoardMemberDTO;
import com.example.demo.mapper.BoardMemberMapper;
import com.example.demo.models.BoardMember;
import com.example.demo.payload.request.CreateBoardMemberRequest;
import com.example.demo.repository.BoardMemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardMemberService {

    private final BoardMemberRepository boardMemberRepository;
    private final BoardMemberMapper boardMemberMapper;

    //Skapa boardmember
    public BoardMemberDTO createBoardMember(CreateBoardMemberRequest req) {
        BoardMember boardMember = boardMemberMapper.fromCreateBoardMemberRequest(req);

        BoardMember savedBoardMember = boardMemberRepository.save(boardMember);
        return boardMemberMapper.toDTO(savedBoardMember);
    }

    //Hämta boardmember via ID
    public BoardMemberDTO findBoardMemberById(Long id) {
        BoardMember boardMember = boardMemberRepository.findById(id).orElse(null);
        return boardMemberMapper.toDTO(boardMember);
    }

    //Hämta alla boardmember
    public List<BoardMemberDTO> findAllBoardMembers() {
        List<BoardMemberDTO> boardMembers = boardMemberRepository.findAll()
                .stream()
                .map(boardMemberMapper::toDTO)
                .toList();

        return boardMembers;

    }

    //Uppdatera boardmember
    public BoardMemberDTO updateBoardMemberById(Long id, CreateBoardMemberRequest req) {
        BoardMember boardMember = boardMemberRepository.findById(id).orElse(null);

        //Uppdatera fält
        boardMember.setAddress(req.adress());
        boardMember.setEmail(req.email());
        boardMember.setName(req.name());
        boardMember.setPhoneNumber(req.phoneNumber());

        boardMemberRepository.save(boardMember);

        return boardMemberMapper.toDTO(boardMember);
    }

    //Radera boardmember
    public boolean deleteBoardMemberById(Long id) {
        if(boardMemberRepository.existsById(id)) {
            boardMemberRepository.deleteById(id);
        }
        return false;
    }

}
