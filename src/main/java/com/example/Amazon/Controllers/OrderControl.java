package com.example.Amazon.Controllers;

import com.example.Amazon.RequestDTOs.AddItemDTO;
import com.example.Amazon.RequestDTOs.AddOrderDTO;
import com.example.Amazon.Services.ItemServ;
import com.example.Amazon.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")

public class OrderControl {
    @Autowired
    private OrderService orderService;
    @PostMapping("/addOrder")
    public ResponseEntity addOrder(@RequestBody AddOrderDTO addOrderDTO) {
        return new ResponseEntity <> ( orderService.addOrder(addOrderDTO) , HttpStatus.CREATED);
    }
}
