package com.example.hw50.service;

import com.example.hw50.dao.PostDao;
import com.example.hw50.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostDao postDao;

    public List<PostDto> selectPost(Long id) {
        var postList = postDao.selectPost(id);
        return postList.stream().map(PostDto::from).collect(Collectors.toList());
    }

    public List<PostDto> selectPostByFollowers(Long id) {
        var postList = postDao.selectPostByFollowers(id);
        return postList.stream().map(PostDto::from).collect(Collectors.toList());
    }
}
