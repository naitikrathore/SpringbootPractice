package com.learningrestapi.LearningRESTApi.repository;

import com.learningrestapi.LearningRESTApi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
