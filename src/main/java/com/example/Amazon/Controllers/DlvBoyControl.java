package com.example.Amazon.Controllers;

import com.example.Amazon.Services.DlvBoyServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deliveryBoy")

public class DlvBoyControl {
    @Autowired
    private DlvBoyServ dlvBoyServ;

    @PostMapping("/addDlvBoy")
    public String addDlvBoy(String name,String email,int maxLoad){
        return dlvBoyServ.addDlvBoy(name,email,maxLoad);
    }
    @PutMapping("/assignDlvBoyToOrder")
    public String assignDlvBoyToOrder( int OrderId){
        return dlvBoyServ.assignDlvBoyToOrder(OrderId);
    }


}
