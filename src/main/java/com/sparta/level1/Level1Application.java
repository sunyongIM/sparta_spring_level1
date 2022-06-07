package com.sparta.level1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  // 생성날짜, 수정날짜를 위해 변화를 감지하고 있는 것 (리스닝)
@SpringBootApplication
public class Level1Application {

    public static void main(String[] args) {
        SpringApplication.run(Level1Application.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(BoardRepository repository, BoardService boardService) {
//        return (args) -> {
//            /// 데이터 저장 및 조회
//            Board board1 = new Board("제목", "콘텐츠", "작성자");
//            repository.save(board1);
//            // BoardRepository에서 JpaRepository<Board, Long>를 상속했기 때문에
//            // repository관련 메소드를 사용할 수 있다
//            List<Board> boardList = repository.findAll();
//
//            for (int i = 0; i < boardList.size(); i++) {
//                Board b = boardList.get(i);
//                System.out.println(b.getTitle());
//            }
//
//        };
//    }
}
