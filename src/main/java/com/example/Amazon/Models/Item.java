package com.example.Amazon.Models;

import com.example.Amazon.Enums.ItemCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.*;

@Entity
@Table(name="item_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY,example = "123")
    private int id;
    boolean isSold;
    @Enumerated(value = EnumType.STRING)
    private ItemCategory itemCategory;
    private String description;

    @JoinColumn
    @ManyToOne
    @JsonIgnore
    private Order order;

}
