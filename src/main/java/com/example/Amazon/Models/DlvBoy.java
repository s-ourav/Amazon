package com.example.Amazon.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

@Entity
@Table(name="dlvboy_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DlvBoy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY,example = "123")
    private int id;
    private String name;
    private String email;
    private int maxLoad; // at a time how many undelivered orders can he be assigned

    @OneToMany (mappedBy = "dlvboy")
    @JsonIgnore
    private List<Order> orderArrayList=new ArrayList<>();

}
