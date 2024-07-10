package com.example.board_api.service;

import com.example.board_api.dao.BoardDao;
import com.example.board_api.dto.BoardDTO;
import com.example.board_api.dto.BoardListDTO;
import com.example.board_api.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardDao boardDao;

    @Override
    public ResponseEntity<?> findAll() {
        try {
            List<BoardListDTO> boardList = boardDao.findAll(); // Mapper 호출
            Boolean state = false;
            String message = "게시글이 존재하지 않습니다.";

            if (boardList.size() != 0) {
                state = true;
                message = "조회 완료";
            }

            ResponseDto result = ResponseDto.builder()
                    .state(state)
                    .data(boardList)
                    .message(message)
                    .build();
            return ResponseEntity.ok(result);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //이건 위랑 합쳐야겠다..
    @Override
    public ResponseEntity<?> detailInfo(String boardId) {
        try {
            BoardDTO post = boardDao.detailInfo(boardId);
            ResponseDto result = ResponseDto.builder()
                    .state(false)
                    .message("조회에 실패했습니다")
                    .build();
            if (post != null) {
                result.setState(true);
                result.setData(post);
                result.setMessage("정상 처리되었습니다.");
            }
            return ResponseEntity.ok(result);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<?> registerBoard(Map<String, String> post) {
        try {
            //글 작성
            if (post.get("type").equals("created")) {
                BoardDTO postData = BoardDTO.builder()
                        .createdBy(convertToInt(post.get("userId")))
                        .title(post.get("title"))
                        .content(post.get("content"))
                        .build();
                int state = boardDao.insertBoard(postData);
                ResponseDto result = ResponseDto.builder().message("등록이 완료되었습니다").state(true).build();
                //실패 시
                if (state != 1) {
                    result.setMessage("등록에 실패했습니다.");
                    result.setState(false);
                }
                return ResponseEntity.ok(result);
            //글 수정
            } else {
                BoardDTO postData = BoardDTO.builder()
                        .boardId(convertToInt(post.get("boardId")))
                        .modifiedBy(convertToInt(post.get("userId")))
                        .title(post.get("title"))
                        .content(post.get("content"))
                        .build();
                int state = boardDao.updateBoard(postData);
                ResponseDto result = ResponseDto.builder().message("수정이 완료되었습니다").state(true).build();
                //실패 시
                if (state != 1) {
                    result.setMessage("수정에 실패했습니다.");
                    result.setState(false);
                }
                return ResponseEntity.ok(result);
            }
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<?> deleteBoard(String boardId){
        try{
            int state = boardDao.deleteBoard(boardId);
            ResponseDto result = ResponseDto.builder().state(false).message("게시글 삭제에 실패했습니다.").build();
            if(state == 1){
                result.setState(true);
                result.setMessage("게시글을 삭제했습니다.");
            }
            return ResponseEntity.ok(result);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    int convertToInt(String keyword){
        return Integer.parseInt(keyword);
    }
}
