package com.example.Amazon.Services;

import com.example.Amazon.Models.Customer;
import com.example.Amazon.Models.Item;
import com.example.Amazon.Models.Order;
import com.example.Amazon.Repos.CustRepo;
import com.example.Amazon.RequestDTOs.AddCustomerDTO;
import com.example.Amazon.ResponseDTOs.GetOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustService {
    @Autowired
    private CustRepo custRepo;
    public String addCustomer(AddCustomerDTO addCustomerDTO){

        Customer newCustomer= Customer.builder()
                .name(addCustomerDTO.getName())
                .email(addCustomerDTO.getEmail())
                .isPrime(addCustomerDTO.isPrime())
                .build();
        custRepo.save(newCustomer);
        return "New customer added with customer ID "+newCustomer.getId();
    }

    public GetOrderDTO getOrdersOfACustomer(int custId ) {
        if(!custRepo.existsById(custId)){ //Cust ID invalid
            return null;
        }

        GetOrderDTO getOrderDTO=new GetOrderDTO();

        Customer customer=custRepo.findById(custId).get();
        for(Order o : customer.getOrderList()){
            getOrderDTO.getItem2dList().add(new ArrayList<>(o.getItemList()));
        }
        return getOrderDTO;
    }

}
