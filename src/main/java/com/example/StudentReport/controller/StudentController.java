package com.example.StudentReport.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentReport.dao.MarksRepository;
import com.example.StudentReport.dao.StudentRepository;
import com.example.StudentReport.entity.Marks;
import com.example.StudentReport.entity.Student;

@RestController
public class StudentController {

	 @Autowired
	  private StudentRepository studentRepository;

	  @Autowired
	  private MarksRepository marksRepository;
	  
	  
	  @GetMapping("/hello")
	  public String printHello() {
		  return "Hello";
	  }
	  
	  @PostMapping("/addstudent")
	  public void addStudentMarks(Student student) {
	    studentRepository.save(student);
	    for (Marks mark : student.getMarks()) {
	      marksRepository.save(mark);
	    }
	  }
	  
	  @GetMapping("/students/{studentId}")
	  public Student getStudentById(@PathVariable Long studentId) {
		  System.out.println("Hello");
	    return studentRepository.findById(studentId).orElse(null);
	  }
	  
	  @GetMapping("/std")
	  public List<Student> getstud() {
		  return studentRepository.findAll();
	  }
	  
	  @GetMapping("/getavgpercentageinrecentsem")
	  public double getAveragePercentageRecentSemester() {
		    List<Marks> recentSemesterMarks = marksRepository.findAll()
		        .stream()
		        .filter(mark -> mark.getSemester() == 2)
		        .collect(Collectors.toList());

		    double totalPercentage = recentSemesterMarks.stream()
		        .mapToDouble(mark -> mark.getScore())
		        .sum();

		    return totalPercentage / recentSemesterMarks.size();
		  }
	  @GetMapping("/getavgmarksinsubject")
	 public double getAverageMarksForSubject(String subject) {
		    List<Marks> marksForSubject = marksRepository.findAll()
		        .stream()
		        .filter(mark -> mark.getSubject().equals(subject))
		        .collect(Collectors.toList());

		    double totalMarks = marksForSubject.stream()
		        .mapToDouble(mark -> mark.getScore())
		        .sum();

		    return totalMarks / marksForSubject.size();
		  }
	  @GetMapping("/gettop2")
	 public List<Student> getTop2ConsistentStudents() {
		    List<Student> students = studentRepository.findAll();

		    return students.stream()
		        .sorted((s1, s2) -> Double.compare(getAverageMarks(s2), getAverageMarks(s1)))
		        .limit(2)
		        .collect(Collectors.toList());
		  }
	  @GetMapping("/getavgmarks")
	private double getAverageMarks(Student student) {
		    List<Marks> marks = student.getMarks();

		    double totalMarks = marks.stream()
		        .mapToDouble(mark -> mark.getScore())
		        .sum();

		    return totalMarks / marks.size();
		  }
}
