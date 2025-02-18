package com.jkcards.services;

import com.jkcards.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order){
        double orderTotal = order.getBasic() - order.getDiscount() +
                shippingService.shipment(order);
        return orderTotal;
    }
}
