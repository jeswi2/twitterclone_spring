package com.nestdigital.twitterbackend.Controller;

import com.nestdigital.twitterbackend.Dao.TwitterDao;
import com.nestdigital.twitterbackend.Model.TwitterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TwitterController {
    @Autowired
    private TwitterDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/adduser",consumes = "application/json",produces = "application/json")
    private String adduser(@RequestBody TwitterModel adduser){
        System.out.println(adduser.toString());
        dao.save(adduser);
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/signin",consumes = "application/json",produces = "application/json")
    public List<TwitterModel> signin(@RequestBody TwitterModel adduser){
        return (List<TwitterModel>) dao.adduser(adduser.getEmail(),adduser.getPassword());

    }
}
