package com.example.Amazon.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customer_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY,example = "123")
    private int id;
    private String name;
    private String email;
    private boolean isPrime;

    @OneToMany (mappedBy = "customer")
    @JsonIgnore
    private List<Order> orderList=new ArrayList<>();
}
