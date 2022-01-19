package com.hcl.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.springboot.entity.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
