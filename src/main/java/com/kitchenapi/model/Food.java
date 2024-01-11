package com.kitchenapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@EntityListeners(AuditingEntityListener.class)
public class Food {
    @Id @GeneratedValue
    private Long id;
    private String name;
    @Column(name = "name_scientific")
    private String scientificName;
    private String description;

    @ManyToOne
    @JoinColumn(name = "food_group")
    private FoodCategory foodGroup;

    @ManyToOne
    @JoinColumn(name = "food_subgroup")
    private FoodCategory foodSubgroup;

    @ManyToOne
    @JoinColumn(name = "food_type")
    private FoodCategory foodType;
    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @Column(name = "creator_id")
    private Long creatorId;
    @Column(name = "updater_id")
    private Long updaterId;

    private String category;


}
