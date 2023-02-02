package com.example.StudentReport.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Marks {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer Id;
//	 @ManyToOne
//	  private Student student;

	  private Integer semester;
	  
	  private String subject;
	  private double score;
}
