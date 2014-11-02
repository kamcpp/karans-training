package jsf;

import co.karans.supermarket.services.api.Product;
import co.karans.supermarket.services.api.ProductServiceClient;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

@ManagedBean
public class AddProductBean {

    @Inject
    private ProductServiceClient productServiceClient;

    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String addProduct() {
        productServiceClient.addProcut(new Product(null, name, price));
        return "show";
    }
}
