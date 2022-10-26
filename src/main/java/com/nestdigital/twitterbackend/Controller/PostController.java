package com.nestdigital.twitterbackend.Controller;

import com.nestdigital.twitterbackend.Dao.PostDao;
import com.nestdigital.twitterbackend.Model.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class PostController {
    @Autowired
    private PostDao dao;


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addpost", consumes = "application/json", produces = "application/json")
    public String addPosts(@RequestBody PostModel post) {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String currentdate = String.valueOf(dt.format(now));
        post.setPosted_date(currentdate);
        System.out.println(post.toString());
        dao.save(post);
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Map<String,String>> Viewpost()
    {
        return (List<Map<String,String>>) dao.ViewAllPosts();
    }
@CrossOrigin(origins = "*")
    @PostMapping("/single")
List<Map<String, String>> ViewSingle(@RequestBody PostModel post)
{
        return (List<Map<String,String>>) dao.ViewSingle(post.getUser_id());
}
}

