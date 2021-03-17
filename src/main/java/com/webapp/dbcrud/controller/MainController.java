package com.webapp.dbcrud.controller;

import com.webapp.dbcrud.entity.Student;
import com.webapp.dbcrud.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private StudentRepo studentrepo;

    @RequestMapping(value = "/data/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private List<Student> getDataAll() {
        return studentrepo.findAll();
    }


}
