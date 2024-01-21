package com.jenkinsEx.JenkinsEx1.controller;


import com.jenkinsEx.JenkinsEx1.model.School;
import com.jenkinsEx.JenkinsEx1.service.SchoolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/JenkinsEx1/school")
public class SchoolController {

    @Autowired
    SchoolServiceImpl schoolService;

    @GetMapping("/getSchools")
    public List<School> getSchools(){
        return schoolService.getSchools();
    }

    @PostMapping("/saveSchool")
    public School saveSchool(@RequestBody School s){
         schoolService.addSchool(s);
         return s;
    }
    @GetMapping("/getSchool/{schoolId}")
    public School getSchool(@ModelAttribute("schoolId") int schoolId){
      return schoolService.getSchool(schoolId);

    }
    @DeleteMapping("/deleteSchool")
    public  School deleteSchool(@RequestBody School s){
        return schoolService.deleteSchool(s);
    }

    @PutMapping("/updateSchool")
    public School updateSchool(@RequestBody School s){
        System.out.println("Updating school");

        return schoolService.updateSchool(s);
    }

}
