package com.sparta.level1.service;

import com.sparta.level1.domain.board.Board;
import com.sparta.level1.domain.board.BoardDTO;
import com.sparta.level1.domain.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // 자동으로 Service 클래스를 만들 때 Repository를 넣어주도록 스프링에게 알려줌
@Service // 스프링에게 이 클래스가 서비스임을 명시
public class BoardService {

    // final: 서비스에게 꼭 필요한 것이다 (생성자에서 사용할 수 있음)
    private final BoardRepository boardRepository;

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, BoardDTO boardDTO){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다")
        );
        board.update(boardDTO);
        return board.getId();
    }
}
