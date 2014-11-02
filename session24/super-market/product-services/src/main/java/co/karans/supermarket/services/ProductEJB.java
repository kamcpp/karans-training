package co.karans.supermarket.services;

import co.karans.supermarket.services.api.Product;
import co.karans.supermarket.services.api.ProductServiceClient;
import domain.ProductEntity;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Remote(ProductServiceClient.class)
public class ProductEJB implements ProductServiceClient {

    @PersistenceContext(unitName = "super-market")
    private EntityManager entityManager;

    public ProductEJB() {
    }

    @Override
    public void addProcut(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        entityManager.persist(productEntity);
    }

    @Override
    public List<Product> getProducts() {
        List<ProductEntity> productEntities = entityManager.createQuery("Select p FROM ProductEntity p ").getResultList();
        List<Product> toReturn = new ArrayList<Product>();
        for (ProductEntity productEntity : productEntities) {
            toReturn.add(convertToProduct(productEntity));
        }
        return toReturn;
    }

    private Product convertToProduct(ProductEntity productEntity) {
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setName(productEntity.getName());
        product.setPrice(productEntity.getPrice());
        return product;
    }
}
