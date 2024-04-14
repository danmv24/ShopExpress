package com.shop.productservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "subcategories")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SubcategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subcategory_name")
    private String subcategoryName;

}
