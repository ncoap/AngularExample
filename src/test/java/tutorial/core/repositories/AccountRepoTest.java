package tutorial.core.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import tutorial.core.models.entities.Account;
import tutorial.core.models.entities.Blog;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Chris on 7/9/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/business-config.xml")

public class AccountRepoTest {

    @Autowired
    private AccountRepo repo;

    @Autowired
    private BlogRepo blogRepo;

    private Account account;

    @Before
    @Transactional
    public void setup() {
        /*account = new Account();
        account.setName("nelson");
        account.setPassword("10200092");
        repo.createAccount(account);*/
    }

    @Test
    @Transactional
    public void testFind() {
        Account account = repo.findAccount(1L);
        System.out.println(account);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void createBlog() {

        Account account1 = repo.findAccount(this.account.getId());

        Blog blog = new Blog();
        blog.setTitle("Information");
        blog.setOwner(account1);

        blogRepo.createBlog(blog);

        System.out.println("BLOG: "+blog);

    }

    @Test
    @Transactional
    public void findBlog(){

        Blog blog = blogRepo.findBlog(1L);
        System.out.println(blog);
        System.out.println("HOLA");
        System.out.println(blog.getOwner());

    }

    @Test
    @Transactional
    public void findAllBlog(){
        //LA GENERACION DE UN QUERY NATIVO RETORNA UN ARRAY DE OBJETOS
        List blogs = blogRepo.findAllBlogs2();
        Object[] blog =(Object[])blogs.get(0);
        System.out.println(blog[0]);
        System.out.println(blog[1]);
        System.out.println(blog[2]);

    }
}
