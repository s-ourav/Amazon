package com.example.Amazon.RequestDTOs;

import com.example.Amazon.Enums.OrderType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddOrderDTO {
     OrderType orderType;
     String ItemsIdsWithSpace;
     int customerID;

     LocalDate bookDate;
     LocalDate deadLine;
}
