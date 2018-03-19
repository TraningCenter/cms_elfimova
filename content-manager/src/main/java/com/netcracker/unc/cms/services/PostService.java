package com.netcracker.unc.cms.services;


import com.netcracker.unc.cms.models.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    Post findById(Long id);
    Post create(Post post);
    Post edit(Post post);
    void deleteById(Long id);
}