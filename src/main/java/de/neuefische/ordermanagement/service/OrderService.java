package de.neuefische.ordermanagement.service;

import de.neuefische.ordermanagement.db.OrderDb;
import de.neuefische.ordermanagement.db.ProductDb;
import de.neuefische.ordermanagement.model.Order;
import de.neuefische.ordermanagement.model.Product;

import java.util.ArrayList;
import java.util.Optional;

public class OrderService {
    private OrderDb orderDb = new OrderDb();
    private ArrayList<Product> products = new ArrayList<>();
    private ProductDb productDb = new ProductDb();

    public Optional<OrderDb> getOrderDb() {
        return Optional.of(orderDb);
    }

    private String addProductIfValid(Optional<Product> product){
        if(product.isPresent()){
            this.products.add(product.get());
            return "Product: " + product.get().getName() + " added!";
        }
        throw new RuntimeException("Product not existent in Database");
        //return "Product not in Database";
    }
    public void createOrder(int id){
        System.out.println(productDb.toString());
        System.out.println("Here a fictional choosing is going on");
        try {
            System.out.println(addProductIfValid(productDb.findProductById(1)));
            System.out.println(addProductIfValid(productDb.findProductById(3)));
            System.out.println(addProductIfValid(productDb.findProductById(4)));
            System.out.println(addProductIfValid(productDb.findProductById(8)));
        } catch (RuntimeException e) {
            System.out.println(e);
        }

        System.out.println(products.toString());
        Order order = new Order(id,products);
        orderDb.addOrder(order);

    }

}
