package ru.netology.repository;
import ru.netology.domain.Product;

public class ProductRepository {
    protected Product[] products = new Product[0];

    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; products.length < 0; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public void remove(int id) {
        int idLength = products.length - 1;
        Product[] tmp = new Product[idLength];
        int copyToIndex = 0;
        for (Product product : products) {
            if(product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }
}
