package com.example.StudentReport.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentReport.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
