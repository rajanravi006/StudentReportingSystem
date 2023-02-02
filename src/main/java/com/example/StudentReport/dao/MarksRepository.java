package com.example.StudentReport.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentReport.entity.Marks;

public interface MarksRepository extends JpaRepository<Marks, Integer> {

}
