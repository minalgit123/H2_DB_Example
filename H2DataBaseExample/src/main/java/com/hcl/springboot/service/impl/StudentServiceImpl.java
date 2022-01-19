package com.hcl.springboot.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.springboot.dto.StudentRequestDto;
import com.hcl.springboot.dto.StudentResponseDto;
import com.hcl.springboot.entity.Student;
import com.hcl.springboot.exception.StudentNotFoundException;
import com.hcl.springboot.repository.IStudentRepository;
import com.hcl.springboot.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentRepository studentRepository;

	@Override
	public boolean saveStudentData(StudentRequestDto studentRequestDto) {
		Student student = new Student();
		BeanUtils.copyProperties(studentRequestDto, student);
		Student savedStudent = studentRepository.save(student);
		if (savedStudent != null)
			return true;

		return false;
	}

	@Override
	public List<StudentResponseDto> getStudentDetails() {
		List<StudentResponseDto> studentResponseList = new ArrayList<>();
		Iterator it = studentRepository.findAll().iterator();

		while (it.hasNext()) {
			StudentResponseDto responseDto = new StudentResponseDto();
			BeanUtils.copyProperties(it.next(), responseDto);
			studentResponseList.add(responseDto);
		}
		return studentResponseList;
	}

	@Override
	public void deleteStudentDetails(int studentId) {
		studentRepository.deleteById(studentId);

	}

	@Override
	public void updateStudent(int studentId, StudentRequestDto studentRequestDto) {
		Optional<Student> studentOptional = studentRepository.findById(studentId);

		if (studentOptional.isEmpty())
			throw new StudentNotFoundException("No student with the id: " + studentId);

		Student student = new Student();
		BeanUtils.copyProperties(studentRequestDto, student);
		student.setStudentId(studentId);

		studentRepository.save(student);

	}

}
