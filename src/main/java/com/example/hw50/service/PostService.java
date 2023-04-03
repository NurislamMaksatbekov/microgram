package com.example.hw50.service;

import com.example.hw50.dao.PostDao;
import com.example.hw50.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostDao postDao;

    public List<Post> selectPost(Long id) {
        return postDao.selectPost(id);
    }

    public List<Post> selectPostByFollowers(Long id) {
        return postDao.selectPostByFollowers(id);
    }

}
