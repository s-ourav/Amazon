package com.example.Amazon.Services;

import com.example.Amazon.Models.*;
import com.example.Amazon.Repos.*;
import com.example.Amazon.Repos.ItemRepo;
import com.example.Amazon.RequestDTOs.AddOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private CustRepo custRepo;
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private OrderRepo orderRepo;

    public String addOrder(AddOrderDTO addOrderDto){
        if(addOrderDto.getItemsIdsWithSpace().length()==0)
            return "No items in order";

        Order order=new Order();
        order.setOrderType(addOrderDto.getOrderType());
        order.setBookDate(addOrderDto.getBookDate());
        order.setDeadLine(addOrderDto.getDeadLine());

        String items[]= addOrderDto.getItemsIdsWithSpace().split(" ");
        List<Item> itemList=new ArrayList<>();
        String itemsDontExist="";
        for (String id:items){
            int itemId= Integer.parseInt(id);
            if(!itemRepo.existsById(itemId)){
                return "One or more items doesn't exist .Hence order can't be processed";
            }

            Item item=itemRepo.findById(itemId).get();
            if(item.isSold()){
                return "One or more items is out of stock.Hence order can't be processed";
            }
            item.setSold(true);
            item.setOrder(order);
            itemList.add(item);
        }

        order.setItemList(itemList);

        int custId=addOrderDto.getCustomerID();
        if(!custRepo.existsById(custId))
            return "Invalid Customer ID";
        Customer customer=custRepo.findById(custId).get();
       // customer.getOrderList().add(order);
        order.setCustomer(customer);
        orderRepo.save(order);
        //custRepo.save(customer);

        return "New Order placed by "+ customer.getName()+" with order ID "+order.getId();

    }

    public String addPickup(){
        return "";
    }


}
