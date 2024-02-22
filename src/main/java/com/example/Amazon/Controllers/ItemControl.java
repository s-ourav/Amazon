package com.example.Amazon.Controllers;

import com.example.Amazon.RequestDTOs.AddItemDTO;
import com.example.Amazon.Services.ItemServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")

public class ItemControl {
    @Autowired
    private ItemServ itemServ;
    @PostMapping("/addItem")
    public ResponseEntity addItem(@RequestBody AddItemDTO addItemDTO) {
        return new ResponseEntity <> ( itemServ.addItem(addItemDTO) , HttpStatus.CREATED);
    }
}
