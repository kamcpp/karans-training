package co.karans.supermarket.services.api;

import java.util.List;

public interface ProductServiceClient {

    void addProcut(Product product);

    List<Product> getProducts();
}
