package de.neuefische.ordermanagement.db;

import de.neuefische.ordermanagement.model.Order;
import de.neuefische.ordermanagement.model.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class OrderDb {
    private ArrayList<Order> orders = new ArrayList<Order>();

    public OrderDb(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public Collection<Order> listOrders() {
        return Collections.unmodifiableCollection(orders);
    }

    public Optional<Order> findOrderById(int id){
        for(Order order : this.orders){
            if(order.getId()== id){
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }

    public void addOrder(Order order){
        Optional<Order> existingOrder = findOrderById(order.getId());
        if(existingOrder.isPresent()){
            throw new RuntimeException("ID already exists");
        }
        this.orders.add(order);
    }

}
