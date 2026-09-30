package com.marcos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.marcos.enums.Category;
import com.marcos.model.Course;
import com.marcos.model.Lesson;
import com.marcos.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository){
		return args -> {
			courseRepository.deleteAll();

			for (int i = 0; i < 20; i++) {

				Course c = new Course();
				c.setName("Angular com Spring");
				c.setCategory(Category.FRONT_END);
				// c.setCategory("Front-end");
				Lesson l = new Lesson();
				l.setName("Introdução");
				l.setYoutubeUrl("watch?v=ZvEKiC_IYhs&t=6s");
				l.setCourse(c);
				c.getLessons().add(l);

				Lesson l1 = new Lesson();
				l1.setName("Angular");
				l1.setYoutubeUrl("watch?v=ZvEKiC_IYhs&t=6s");
				l1.setCourse(c);
				c.getLessons().add(l1);

				courseRepository.save(c);
			}	
		};
		
	}
}
