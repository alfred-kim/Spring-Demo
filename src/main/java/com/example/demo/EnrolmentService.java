package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrolmentService {

    @Autowired
    private EnrolmentRepository repository ; 

    public Enrolment addEnrolment(Enrolment enrolment){
        return repository.save(enrolment) ;
    }

    public List<Enrolment>getEnrolments(){
        return repository.findAll() ;
    }

    public Enrolment updateEnrolment(int id ,Enrolment enrolment){
        Enrolment existing = repository.findById(id).orElseThrow(()->new RuntimeException("Enrolment does not exist with id " + id)) ;
        existing.setStudent(enrolment.getStudent()) ; 
        existing.setCourse(enrolment.getCourse()) ; 
        existing.setEnrolmentDate(enrolment.getEnrolmentDate()) ;
        return repository.save(existing) ; 
    }

    public boolean deleteEnrolment(int id){
        if(repository.existsById(id)){
            repository.deleteById(id) ; 
            return true ; 
        }
        else
            return false ; 
    }

    public List<Enrolment> findByStudentId(int id){
        return repository.findByStudentId(id) ;
    }

    public List<Enrolment> findByCourseId(int id){
        return repository.findByCourseId(id) ;
    }


    
}
