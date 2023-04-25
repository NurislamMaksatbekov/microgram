package com.example.hw50.service;

import com.example.hw50.dao.CommentDao;
import com.example.hw50.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentDao commentDao;

    public List<CommentDto> showComments(Long postId){
        var commentList = commentDao.showComments(postId);
        return commentList.stream().map(CommentDto::from).collect(Collectors.toList());
    }
}
