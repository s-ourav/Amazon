package com.example.Amazon.ResponseDTOs;

import com.example.Amazon.Models.Item;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetOrderDTO {
    List<List<Item>> item2dList =new ArrayList<>();
}
