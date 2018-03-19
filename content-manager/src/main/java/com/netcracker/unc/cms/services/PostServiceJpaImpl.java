package com.netcracker.unc.cms.services;


import com.netcracker.unc.cms.models.Post;
import com.netcracker.unc.cms.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PostServiceJpaImpl implements PostService {

    private final PostRepository postRepo;

    public PostServiceJpaImpl(PostRepository postRepo) {
        this.postRepo = Objects.requireNonNull(postRepo);
    }

    @Override
    public List<Post> findAll() {
        return this.postRepo.findAll();
    }


    @Override
    public Post findById(Long id) {
        return this.postRepo.findOne(id);
    }

    @Override
    public Post create(Post post) {
        return this.postRepo.save(post);
    }

    @Override
    public Post edit(Post post) {
        return this.postRepo.save(post);
    }

    @Override
    public void deleteById(Long id) {
        this.postRepo.delete(id);
    }

}