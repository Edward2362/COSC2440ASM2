package com.tutorial.example2;

import com.tutorial.example2.config.AppConfig;
import com.tutorial.example2.entity.Course;
import com.tutorial.example2.service.StudentService;
import com.tutorial.example2.service.CourseService;
import com.tutorial.example2.entity.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {


    public static void main(String[] args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        StudentService studentService = (StudentService) context.getBean("studentService");

        Student student = new Student();
        student.setName("Minh");
        studentService.saveStudent(student);

        CourseService courseService = (CourseService) context.getBean("courseService");

        Course sadi = new Course();
        sadi.setName("Sadi");
        sadi.setStudent(student);
        courseService.saveCourse(sadi);

        Course wp = new Course();
        wp.setName("Web programming");
        wp.setStudent(student);
        courseService.saveCourse(wp);

        Student newStudent =  studentService.getStudentById(1);
        //Do nothing
        System.out.println(newStudent.getCourses().size());
        for(Course course: newStudent.getCourses()){
            System.out.println(course.getName());
        }

  
        Course newCourse = courseService.getCourseById(1);
        System.out.println(newCourse.getStudent().getName());

	//Try delete the student to see what happens? (Add cascade to handle the problem)
        

    }

}
