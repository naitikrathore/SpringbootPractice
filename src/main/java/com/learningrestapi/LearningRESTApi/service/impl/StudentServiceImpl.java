package com.learningrestapi.LearningRESTApi.service.impl;

import com.learningrestapi.LearningRESTApi.dto.AddStudentRequestDto;
import com.learningrestapi.LearningRESTApi.dto.StudentDto;
import com.learningrestapi.LearningRESTApi.service.StudentService;
import com.learningrestapi.LearningRESTApi.service.entity.Student;
import com.learningrestapi.LearningRESTApi.service.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor  //because of this annotation all the files with final will be injected by spring
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> allStudents = studentRepository.findAll();

        return allStudents
                .stream()
                .map(student -> modelMapper.map(student,StudentDto.class))
                .toList();
    }

    @Override
    public boolean deleteEntryById(Long id) {
        studentRepository.deleteById(id);
        return !studentRepository.existsById(id);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.getReferenceById(id);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto createEntry(AddStudentRequestDto addStudentRequestDto) {
        Student student = modelMapper.map(addStudentRequestDto,Student.class);
        return modelMapper.map(studentRepository.save(student),StudentDto.class);
    }
}
