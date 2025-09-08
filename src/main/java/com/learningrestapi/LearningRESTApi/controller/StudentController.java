package com.learningrestapi.LearningRESTApi.controller;

import com.learningrestapi.LearningRESTApi.dto.AddStudentRequestDto;
import com.learningrestapi.LearningRESTApi.dto.StudentDto;
import com.learningrestapi.LearningRESTApi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @RestController is a convenience annotation that combines @Controller and @ResponseBody.
 * <p>
 * - @Controller: Marks the class as a Spring MVC controller and registers it as a bean
 *   in the IoC container (ApplicationContext).
 * <p>
 * - @ResponseBody: Indicates that the return values of request-handling methods should be
 *   written directly to the HTTP response body (typically serialized to JSON or XML),
 *   instead of rendering a view (like JSP/Thymeleaf).
 * <p>
 * Together, @RestController is typically used in REST APIs where methods return data objects
 * rather than HTML views.
 */

@RestController
@RequestMapping("/students") // Base path for all methods
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>>getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        System.out.println("get function called with id " + id);
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteEntryById(@PathVariable Long id){
        System.out.println("delete function called with id  " + id);
        boolean deleted = studentService.deleteEntryById(id);

        if(deleted)
            return ResponseEntity.ok(true);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudentEntry(@RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createEntry(addStudentRequestDto));
    }
}
