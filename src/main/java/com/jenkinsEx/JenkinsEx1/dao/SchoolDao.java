package com.jenkinsEx.JenkinsEx1.dao;



import com.jenkinsEx.JenkinsEx1.model.School;

import java.util.List;

public interface SchoolDao {

    public List<School> getSchools();

    public School getSchool(int schoolId);

    public void addSchool(School s);

    public School deleteSchool(School s);

    public School updateSchool(School s);

}
