package com.example.Amazon.RequestDTOs;

import com.example.Amazon.Enums.ItemCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddItemDTO {
    private ItemCategory itemCategory;
    private String description;
}
