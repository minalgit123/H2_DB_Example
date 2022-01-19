package com.hcl.springboot.service;

import java.util.List;

import com.hcl.springboot.dto.StudentRequestDto;
import com.hcl.springboot.dto.StudentResponseDto;

public interface IStudentService {

	List<StudentResponseDto> getStudentDetails();

	boolean saveStudentData(StudentRequestDto studentRequestDto);

	void deleteStudentDetails(int studentId);



	void updateStudent(int studentId, StudentRequestDto studentRequestDto);







}