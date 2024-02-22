package com.example.Amazon.Models;

import com.example.Amazon.Enums.OrderType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="order_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY,example = "123")
    private int id;

    @Enumerated(value = EnumType.STRING)
    private OrderType orderType;
    private boolean isDelivered=false;


    @OneToMany (mappedBy = "order")
    @JsonIgnore
    private List<Item> itemList=new ArrayList<>();

    @JoinColumn
    @ManyToOne
    @JsonIgnore
    private DlvBoy dlvboy;


    @JoinColumn
    @ManyToOne
    @JsonIgnore
    private Customer customer;

    private LocalDate bookDate;
    private LocalDate deadLine;


}
