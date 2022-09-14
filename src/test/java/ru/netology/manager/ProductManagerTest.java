package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    private ProductRepository repo = new ProductRepository();
    private ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(11, "Ревность", 1000, "Ю Несбе");
    Product book2 = new Book(18, "99 франков", 1400, "Фредерик Бегбедер");
    Product book3 = new Book(6, "Так говорил Заратустра", 2000, "Фридрих Ницше");
    Product smartphone1 = new Smartphone(28, "IPhone 14", 100_000, "Apple");
    Product smartphone2 = new Smartphone(71, "Xiaomi Poco X14", 30_000, "Xiaomi");
    Product smartphone3 = new Smartphone(22, "Razer V3", 70_000, "Motorolla");

    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    public void addProduct() {
        manager.add(book3);

        Product[] expected = new Product[] {book3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void nameSearch() {
        setUp();

        Product[] expected = new Product[] {smartphone1};
        Product[] actual = manager.searchBy("IPhone 14");

        Assertions.assertArrayEquals(expected, actual);
    }
}
