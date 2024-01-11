package com.kitchenapi.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodCategory {
    @Id @GeneratedValue
    private Long id;
    private String name;

}
