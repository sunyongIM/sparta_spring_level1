package com.sparta.level1.controller;

import com.sparta.level1.domain.board.Board;
import com.sparta.level1.domain.board.BoardDTO;
import com.sparta.level1.domain.board.BoardRepository;
import com.sparta.level1.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;


    // 2. 게시글 작성
    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardDTO boardDTO) {

        Board board = new Board(boardDTO);

        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return boardRepository.save(board);
    }

    // 1. 전체 게시글 목록(시간순) 조회
    @GetMapping("/api/boards")
    public List<Board> getBoards(){
//        return boardRepository.findAll();
        // 작성 날짜 기준 내림차순 정렬
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }
    
    // 2. id로 게시글 조회
    @GetMapping("/api/board/{id}")
    public Board getBoard(@PathVariable Long id){
        return boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id의 게시물이 존재하지 않습니다")
        );
    }

    // 4. 게시글 수정
    @PutMapping("/api/boards/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardDTO boardDTO){
        return boardService.update(id, boardDTO);
    }

    // 5. 게시글 삭제
    @DeleteMapping("/api/boards/{id}")
    public Long deleteBoard(@PathVariable Long id){
        boardRepository.deleteById(id);
        return id;
    }

}
