package com.netcracker.unc.cms;

import com.netcracker.unc.cms.models.Post;
import com.netcracker.unc.cms.services.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@ContextConfiguration(classes = DbTest.TestConfig.class)
public class DbTest {
    @Autowired
    private TestEntityManager entityManager;


    @Autowired
    private PostService postService;

    @Test
    public void findByPostIdShouldReturnPost() {
        Post postForSave = new Post("sboot", "123");
        this.entityManager.persist(postForSave);
        Post post = this.postService.findById(postForSave.getId());

        assertThat(post.getTitle()).isEqualTo("sboot");
    }

    @Test
    public void givenPostSaveGetOk() {
        Post post = new Post();
        post.setId(11L);
        post.setTitle("привет");
        postService.create(post);
        Post saved = postService.findById(post.getId());

        assertEquals("name correct", "привет", saved.getTitle());
    }

    @TestConfiguration
    @ComponentScan({
            "com.netcracker.unc.cms.repositories",
            "com.netcracker.unc.cms.services"
    })
    static class TestConfig {

    }
}