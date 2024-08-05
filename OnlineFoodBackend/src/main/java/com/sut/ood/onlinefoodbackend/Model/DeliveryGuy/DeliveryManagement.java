package com.sut.ood.onlinefoodbackend.Model.DeliveryGuy;
import com.sut.ood.onlinefoodbackend.Model.Customer.Order;
import com.sut.ood.onlinefoodbackend.Model.Enum.OrderStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class DeliveryManagement {
    private ArrayList<DeliveryGuy> freeDeliveryGuys ;
    private ArrayList<DeliveryGuy> busyDeliveryGuys ;
    private ArrayList<Order> activeOrders;


    private void updateActiveDeliveryGuys(){
        return; //khodesh seda mikone, nmidunam az koja bayad bgire listo
    }

    private void updateActiveOrders(){
        return; //baz haminjuri
    }

    public boolean allocateDelivery(Order order) {
        if (!freeDeliveryGuys.isEmpty()){
                DeliveryGuy dg = freeDeliveryGuys.get(0);
                dg.acceptDelivery(order);
                order.setStatus(OrderStatus.Waiting_For_Accepting_Delivery_Guy.toString());
                freeDeliveryGuys.remove(0);
                busyDeliveryGuys.add(dg);
                return true;
            }
        return false;
        //khata: delivery khali nadarim k inja ya mintazere khali shodan mimune, ya ba fasele zamani baz check mikone
    }

    public void TrackDeliveryStatus(Order order){
        return;
    }

    public void OptimizeDeliveryRoutes(){
        return; //no idea wtf this one's gonna do
    }

    public void activeDeliveryGuy(DeliveryGuy dg) {
        if (!dg.isActive()) {
            dg.setActive(true);
            freeDeliveryGuys.add(dg);
        }
    }

}

