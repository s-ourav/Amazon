package com.example.Amazon.RequestDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddCustomerDTO {

    String name;
    String email;
    boolean isPrime;
}
