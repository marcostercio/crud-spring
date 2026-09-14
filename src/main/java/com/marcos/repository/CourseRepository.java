package com.marcos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marcos.model.Course;

public interface CourseRepository extends JpaRepository< Course,Long>{
    
}
