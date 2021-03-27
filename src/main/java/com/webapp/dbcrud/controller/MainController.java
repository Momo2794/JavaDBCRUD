package com.webapp.dbcrud.controller;

import com.webapp.dbcrud.entity.Student;
import com.webapp.dbcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/data/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private List<Student> getDataAll() {
        return studentService.getAllStudent();
    }

    @RequestMapping(value = "/about")
    private String mapToAbout() {
        return "about";
    }

    @RequestMapping(value = "/contact")
    private String mapToContact(){
        return "contact";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    private String mapToIndex(Model model) {
        model.addAttribute("studentsList", studentService.getAllStudent());
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    private ModelAndView mapToCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        Student student = new Student();
        modelAndView.addObject("studentTmp", student);
        return modelAndView;
    }

    @RequestMapping(value = "/create_save", method = RequestMethod.POST)
    private String saveStudent(@ModelAttribute("studentTmp") Student student){
        studentService.saveorupdateStudent(student);
        return "redirect:/index";
    }

    @RequestMapping(value = "/edit/{sid}", method = RequestMethod.GET)
    private ModelAndView editStudent(@PathVariable(name = "sid") long sid){
        ModelAndView modelAndView = new ModelAndView("edit");
        Student student = studentService.getStudentById(sid);
        modelAndView.addObject("studentTmp", student);
        return modelAndView;
    }

    @RequestMapping(value = "/edit_save", method = RequestMethod.POST)
    private String saveeditStudent(@ModelAttribute("studentTmp") Student student){
        studentService.saveorupdateStudent(student);
        return "redirect:/index";
    }

    @RequestMapping(value = "/delete/{sid}", method = RequestMethod.GET)
    private String deleteStudent(@PathVariable long sid){
        studentService.deleteStudent(sid);
        return "redirect:/index";
    }
}
