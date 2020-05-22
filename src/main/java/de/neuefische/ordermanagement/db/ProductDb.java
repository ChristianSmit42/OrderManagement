package de.neuefische.ordermanagement.db;


import de.neuefische.ordermanagement.model.Product;

import java.util.*;

public class ProductDb {
    private final ArrayList<Product> products = new ArrayList<Product>();

    public ProductDb(Collection<Product> products) {
        this.products.addAll(products);
    }

    public Collection<Product> listProducts() {
        return Collections.unmodifiableCollection(this.products);
    }

    public Optional<Product> findProductById(int id){
        for(Product product: this.products){
            if(product.getId()== id){
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return "ProductDb{" +
                "products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDb productDb = (ProductDb) o;
        return Objects.equals(products, productDb.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }
}
