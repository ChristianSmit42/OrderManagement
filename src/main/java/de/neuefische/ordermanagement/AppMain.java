package de.neuefische.ordermanagement;

import de.neuefische.ordermanagement.db.OrderDb;
import de.neuefische.ordermanagement.db.ProductDb;
import de.neuefische.ordermanagement.model.Product;
import de.neuefische.ordermanagement.service.OrderService;

import java.util.ArrayList;
import java.util.Optional;

public class AppMain {

    public static void main(String[] args){


        ProductDb productDb = new ProductDb();
        OrderService orderService = new OrderService();
      //AUFGABE 2

        for(Product product: productDb.listProducts()){
            System.out.println(product.toString());
        }

        // Aufgabe 4
        orderService.createOrder(1);
        orderService.createOrder(2);


        // Aufgabe 5
        Optional<OrderDb> optOrderDb = orderService.getOrderDb();
        if(optOrderDb.isPresent()){
            System.out.println(optOrderDb.get().toString());
        }



    }
}
