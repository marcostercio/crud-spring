package com.marcos.dto.mapper;

import com.marcos.CrudSpringApplication;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.marcos.dto.CourseDTO;
import com.marcos.dto.LessonDTO;
import com.marcos.enums.Category;
import com.marcos.model.Course;
import com.marcos.model.Lesson;

@Component 
public class CourseMapper {


    private final CrudSpringApplication crudSpringApplication;

    CourseMapper(CrudSpringApplication crudSpringApplication) {
        this.crudSpringApplication = crudSpringApplication;
    }
    public CourseDTO toDTO(Course course) { 
      if(course == null) {
          return null;
      }
        List<LessonDTO> lessons = course.getLessons()
        .stream()
          .map(lesson -> new LessonDTO(lesson.getId(), lesson.getName(), 
          lesson.getYoutubeUrl()))
          .toList();
          
        return new CourseDTO(course.getId(), course.getName(), course.getCategory().getValue(), lessons);
    }
    public Course toEntity(CourseDTO courseDTO) {
      if (  courseDTO == null) {
          return null;
      }

        Course course = new Course();
        if(courseDTO.id() != null) {
            course.setId(courseDTO.id());
        }
        course.setName(courseDTO.name());
        //todo: use o mapper for category
        course.setCategory(convertCategoryValue(courseDTO.category()));

        List<Lesson> lessons = courseDTO.lessons().stream().map(lessonDTO -> {
          var lesson = new Lesson();
          lesson.setId(lessonDTO.id());
          lesson.setName(lessonDTO.name());
          lesson.setYoutubeUrl(lessonDTO.youtubeUrl());
          lesson.setCourse(course);
          return lesson;
        }).collect(Collectors.toList());
        course.setLessons(lessons);
        
        return course;
    }

    public Category convertCategoryValue(String value){
      if(value == null) {
          return null;
      }
     return switch (value) {
        case "Front-end" -> Category.FRONT_END;
        case "Back-end" -> Category.BACK_END; 
        default -> throw new IllegalArgumentException("Categoria inválida: " + value);
      };

    }
}
