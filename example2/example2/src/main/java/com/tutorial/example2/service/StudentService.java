package com.tutorial.example2.service;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.example2.entity.Student;

import java.util.List;


@Transactional
public class StudentService {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void saveStudent(Student student){
        sessionFactory.getCurrentSession().save(student);
    }

    public void updateStudent(Student student){
        sessionFactory.getCurrentSession().update(student);
    }
    
    public List<Student> getAllStudents(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Student.class);
        return criteria.list();
    }

    public void deleteStudent(Student student){
        sessionFactory.getCurrentSession().delete(student);
    }

    public Student getStudentById(int id){
        return (Student)sessionFactory.getCurrentSession().get(Student.class, id);
    }

    public List<Student> getStudentByName(String name){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Student.class);
        criteria.add(Restrictions.like("name",name, MatchMode.ANYWHERE));
        return criteria.list();
    }
}

