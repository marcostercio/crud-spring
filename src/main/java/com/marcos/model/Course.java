package com.marcos.model;


import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import com.marcos.enums.Category;
import com.marcos.enums.converters.CategoryConverter;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.SoftDelete;

@Data
@Entity

@SoftDelete 
// @Where("status = 'Ativo'")
public class Course {
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @Length(min = 5, max = 100) 
    @NotBlank 
    @NotNull 
    @Column(length = 100, nullable = false)
    private String name;

    // @Length (max = 10)
    //@Pattern(regexp = "Back-end|Front-end")
    @NotNull 
    @Column(length = 10, nullable = false)
    @Convert(converter = CategoryConverter.class)
    private Category category;

    // @NotNull 
    // @Length (max = 10)
    // @Pattern(regexp = "Ativo|Inativo")
    // @Column(length = 10, nullable = false)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "course")
    //@JoinColumn(name = "course_id")
    private List<Lesson> lessons = new ArrayList<>();
}
        