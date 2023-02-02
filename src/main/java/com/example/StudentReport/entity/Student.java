package com.example.StudentReport.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor	
public class Student {
	
	  @Id
//	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long studentId;

	  private String name;

//	  @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	  @OneToMany(cascade=CascadeType.ALL)
	  @JoinColumn(name="studentId")
	  private List<Marks> marks;
}
