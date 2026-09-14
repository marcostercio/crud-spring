package com.marcos.model;


import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
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

    @NotNull 
    @Length (max = 10)
    @Pattern(regexp = "Back-end|Front-end")
    @Column(length = 10, nullable = false)
    private String category;

    // @NotNull 
    // @Length (max = 10)
    // @Pattern(regexp = "Ativo|Inativo")
    // @Column(length = 10, nullable = false)

}
