package jsf;

import co.karans.supermarket.services.api.Product;
import co.karans.supermarket.services.api.ProductServiceClient;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
public class ShowProductsBean {

    @Inject
    private ProductServiceClient productServiceClient;

    public List<Product> getProducts() {
        return productServiceClient.getProducts();
    }
}
