package com.example.Amazon.Controllers;

import com.example.Amazon.RequestDTOs.AddCustomerDTO;
import com.example.Amazon.RequestDTOs.AddItemDTO;
import com.example.Amazon.ResponseDTOs.GetOrderDTO;
import com.example.Amazon.Services.CustService;
import com.example.Amazon.Services.ItemServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustControl {

    @Autowired
    private CustService custService;
    @PostMapping("/addCustomer")
    public ResponseEntity addCustomer(@RequestBody AddCustomerDTO addCustomerDTO ) {
        return new ResponseEntity <> ( custService.addCustomer(addCustomerDTO) , HttpStatus.CREATED);
    }

    @GetMapping("/getOrdersOfACustomer")
    public ResponseEntity getOrdersOfACustomer(@RequestParam int custId ) {
        return new ResponseEntity ( custService.getOrdersOfACustomer(custId) , HttpStatus.OK);
    }
}
