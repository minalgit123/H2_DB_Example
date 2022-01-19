package com.hcl.springboot.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.hcl.springboot.dto.StudentRequestDto;
import com.hcl.springboot.dto.StudentResponseDto;
import com.hcl.springboot.service.IStudentService;

@RestController
public class StudentController {

	@Autowired
	private IStudentService studentService;


	@PostMapping("/students")
	public ResponseEntity<String> saveStudentData(@Valid @RequestBody StudentRequestDto studentRequestDto) {
		boolean response = studentService.saveStudentData(studentRequestDto);
		
		if(response) return new  ResponseEntity<String>("Data saved succesfully",HttpStatus.OK);
		return new  ResponseEntity<String>("Data saved Unsuccesfull",HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	
	@GetMapping("/students") 
	public List<StudentResponseDto>getStudentDetails()
	  { 
		
		return studentService.getStudentDetails();
	 
	  }
	
	@DeleteMapping("/students/{studentId}") 
	public String deleteStudentDetails(@NotNull @PathVariable  int studentId )
	  { 
		 studentService.deleteStudentDetails(studentId);
		return "data deleted successfully";
	 
	  }
	
	@PutMapping("/students/{studentId}")  
	private ResponseEntity<String>updateStudent(@PathVariable int studentId,@RequestBody StudentRequestDto studentRequestDto)   
	{  
	studentService.updateStudent(studentId,studentRequestDto);  
	return new ResponseEntity<String>("Student updated succesfully",HttpStatus.OK); 
	}  
	
}