package com.springmssqlthree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmssqlthree.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
  
}
