package com.example.prjjsp2.service;

import com.example.prjjsp2.dto.Board;
import com.example.prjjsp2.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper mapper;

    public void add(Board board) {
        mapper.insert(board);
    }

    public Map<String, Object> list(Integer page) {
        // 한 페이지에 10개

        Integer offset = (page - 1) * 10;

//        List<Board> list = mapper.selectAll();
        List<Board> list = mapper.selectAllPaging(offset);

        // Controller에게 넘겨 줄 정보들을 담을 map
        Map<String, Object> map = new HashMap<>();

        // 페이지 관련 정보들
        Integer countAll = mapper.countAll();
        Integer lastPageNumber = (countAll - 1) / 10 + 1; // 마지막 페이지 번호

        map.put("lastPageNumber", lastPageNumber);
        map.put("boardList", list);

        return map;
    }

    public Board get(Integer id) {
        return mapper.selectById(id);
    }

    public void remove(Integer id) {

        mapper.deleteById(id);
    }

    public void update(Board board) {
        mapper.update(board);
    }
}