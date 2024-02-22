package com.example.Amazon.Services;

import com.example.Amazon.Enums.ItemCategory;
import com.example.Amazon.Models.Item;
import com.example.Amazon.Repos.ItemRepo;
import com.example.Amazon.RequestDTOs.AddItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServ {
    @Autowired
    private ItemRepo itemRepo;

    public String addItem (AddItemDTO addItemDTO){
        ItemCategory itemCategory=addItemDTO.getItemCategory();
        String description = addItemDTO.getDescription();

        Item newItem= Item.builder()
                .itemCategory(itemCategory)
                .description(description)
                .build();
        itemRepo.save(newItem);
        return "New item added with item ID "+ newItem.getId();
    }

}
