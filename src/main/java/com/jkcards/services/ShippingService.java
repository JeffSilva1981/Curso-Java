package com.jkcards.services;

import com.jkcards.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order) {
        double freight;

        if (order.getBasic() < 100.0) {
            freight = 20.0;
        } else if (order.getBasic() < 200.0) {  // Aqui ajustamos para "else if"
            freight = 12.0;
        } else {
            freight = 0.0;
        }
        return freight;
    }
}
