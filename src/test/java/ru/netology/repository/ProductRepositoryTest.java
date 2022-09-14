package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepositoryTest {
    private ProductRepository repo = new ProductRepository();
    Product book1 = new Book(11, "Ревность", 1000, "Ю Несбе");
    Product smartphone2 = new Smartphone(71, "Xiaomi Poco X14", 30_000, "Xiaomi");

    @Test
    public void shouldSaveOne() {
        repo.save(book1);

        Product[] expected = new Product[] {book1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveOne() {
        repo.save(smartphone2);

        repo.remove(71);

        Product[] expected = new Product[] {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
