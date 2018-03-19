package com.netcracker.unc.cms.controllers;

import com.netcracker.unc.cms.models.Post;
import com.netcracker.unc.cms.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/content")
public class PostsController {
    @Autowired
    private PostService postService;

    @GetMapping(path="/{id}")
    public ResponseEntity<Post> getContent(@PathVariable Long id){
        try {
            return ResponseEntity.ok(postService.findById(id));
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Post> addPost(Post post){
        try {
            return ResponseEntity.ok(postService.create(post));
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteContent(@PathVariable Long id){
        try {
            postService.deleteById(id);
            return ResponseEntity.ok("done");
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}