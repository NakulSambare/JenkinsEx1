package com.jenkinsEx.JenkinsEx1.dao;

import com.jenkinsEx.JenkinsEx1.model.School;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SchoolDaoImpl implements SchoolDao{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<School> getSchools() {

        Session currentSession = entityManager.unwrap(Session.class);
        Query<School> query =  currentSession.createNativeQuery("select * from school",School.class);
         List<School> schoolList =   query.getResultList();
        return schoolList;
    }

    @Override
    public School getSchool(int schoolId) {
        Session currentSession = entityManager.unwrap(Session.class);
        //School school =  currentSession.get(School.class,schoolId);
        Query q = currentSession.createNativeQuery("select * from school where school_id = "+schoolId,School.class);
        School result = (School)q.getSingleResult();
       // School s = new School(Integer.parseInt((String) result[0]),(String)result[1],(String)result[2]);
        return result;
    }

    @Override
    public void addSchool(School s) {
        Session currentSession = entityManager.unwrap(Session.class);
          currentSession.persist(s);

    }

    @Override
    public School deleteSchool(School s) {
        Session currentSession = entityManager.unwrap(Session.class);
       // currentSession.delete(s);
        Query<School> query =  currentSession.createQuery("delete from School  where schoolId =:schoolId");
        query.setParameter("schoolId",s.getSchoolId());
        int result = query.executeUpdate();
        return s;
    }

    @Override
    public School updateSchool(School s) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query q = currentSession.createNativeQuery("update school set school_address ="+"'"+s.getSchoolAddress() +"'"+ " , school_name = "+"'"+s.getSchoolName()+"' where school_id ="+s.getSchoolId(),School.class);
       // currentSession.saveOrUpdate(s);
        q.executeUpdate();
        return s;
    }
}
