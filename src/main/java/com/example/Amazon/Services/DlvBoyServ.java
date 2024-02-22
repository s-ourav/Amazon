package com.example.Amazon.Services;

import com.example.Amazon.Models.*;
import com.example.Amazon.Repos.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DlvBoyServ {
    @Autowired
    private DlvBoyRepo dlvBoyRepo;
    @Autowired
    private OrderRepo orderRepo;
    public String addDlvBoy(String name,String email,int maxLoad){
        DlvBoy dlvBoy= DlvBoy.builder()
                .name(name)
                .email(email)
                .maxLoad(maxLoad)
                .build();
        dlvBoyRepo.save(dlvBoy);
        return "New Delivery Boy added with ID  "+dlvBoy.getId();
    }

    public String assignDlvBoyToOrder( int OrderId){ //automatically assigns order to available dlvboy
        if(!orderRepo.existsById(OrderId)){
            return "Wrong order Id";
        }
        Order order=orderRepo.findById(OrderId).get();

        List<DlvBoy> dlvBoyList= dlvBoyRepo.findAll();
        DlvBoy dlvBoy=null;
        for(DlvBoy dlvBoy1:dlvBoyList){
            if(dlvBoy1.getOrderArrayList().size()<dlvBoy1.getMaxLoad()){
                //not reached maxload yet
                dlvBoy = dlvBoy1;
                break;
            }
        }

        if(dlvBoy==null){
            return "No delivery boy available";
        }


        dlvBoy.getOrderArrayList().add(order);
        order.setDelivered(true);
        order.setDlvboy(dlvBoy);
        orderRepo.save(order);
        dlvBoyRepo.save(dlvBoy);
        return "order assigned to DLV BOY with id "+dlvBoy.getId()+" name : "+dlvBoy.getName();
    }
}
