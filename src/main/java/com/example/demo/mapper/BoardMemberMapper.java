package com.example.demo.mapper;

import com.example.demo.dto.BoardMemberDTO;
import com.example.demo.models.BoardMember;
import com.example.demo.payload.request.CreateBoardMemberRequest;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BoardMemberMapper {

    public BoardMember fromCreateBoardMemberRequest(CreateBoardMemberRequest req) {
        BoardMember boardMember = new BoardMember();

        boardMember.setName(req.name());
        boardMember.setEmail(req.email());
        boardMember.setAddress(req.adress());
        boardMember.setPhoneNumber(req.phoneNumber());

        return boardMember;
    }

    public BoardMemberDTO toDTO (BoardMember boardMember) {
        BoardMemberDTO boardMemberDTO = new BoardMemberDTO();

        boardMemberDTO.setId(boardMember.getId());
        boardMemberDTO.setName(boardMember.getName());
        boardMemberDTO.setEmail(boardMember.getEmail());
        boardMemberDTO.setAddress(boardMember.getAddress());
        boardMemberDTO.setPhoneNumber(boardMember.getPhoneNumber());

        return boardMemberDTO;
    }

    public BoardMember toEntity (BoardMemberDTO boardMemberDTO) {
        BoardMember entity = new BoardMember();

        entity.setId(boardMemberDTO.getId());
        entity.setName(boardMemberDTO.getName());
        entity.setEmail(boardMemberDTO.getEmail());
        entity.setAddress(boardMemberDTO.getAddress());
        entity.setPhoneNumber(boardMemberDTO.getPhoneNumber());

        return entity;
    }


}
