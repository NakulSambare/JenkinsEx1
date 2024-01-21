package com.jenkinsEx.JenkinsEx1.service;


import com.jenkinsEx.JenkinsEx1.dao.SchoolDao;
import com.jenkinsEx.JenkinsEx1.model.School;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl {

    @Autowired
    SchoolDao schoolDao;
//    @Transactional
    public List<School> getSchools(){
        return schoolDao.getSchools();
    }
    @Transactional
    public School getSchool(int schoolId){return  schoolDao.getSchool(schoolId);}
    @Transactional
    public void addSchool(School s){
        schoolDao.addSchool(s);
    }
    @Transactional
    public School deleteSchool(School s){return  schoolDao.deleteSchool(s);}
    @Transactional
    public School updateSchool(School s){return  schoolDao.updateSchool(s);}
}
