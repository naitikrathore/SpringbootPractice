package com.learningrestapi.LearningRESTApi.service;

import com.learningrestapi.LearningRESTApi.dto.AddStudentRequestDto;
import com.learningrestapi.LearningRESTApi.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    boolean deleteEntryById(Long id);

    StudentDto getStudentById(Long id);

    StudentDto createEntry(AddStudentRequestDto addStudentRequestDto);
}
