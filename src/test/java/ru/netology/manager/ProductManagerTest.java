package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager productManager = new ProductManager(repository);
    private Book first = new Book(1, "War And Peace", 100, "Lev Tolstoy");
    private Book second = new Book(2, "The Lost World", 200, "Conan Doyle");
    private Smartphone third = new Smartphone(3, "Iphone10", 200, "Apple");
    private Smartphone forth = new Smartphone(4, "Redmi10", 200, "Xiaomi");

    @BeforeEach
    public void setUp() {
        productManager.add(first);
        productManager.add(second);
        productManager.add(third);
        productManager.add(forth);
    }

    @Test
    public void shouldSearchBookName() {
        String text = "War And Peace";

        Product[] actual = productManager.searchBy(text);
        Product[] expected = new Product[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookAuthor() {
        String text = "Conan Doyle";

        Product[] actual = productManager.searchBy(text);
        Product[] expected = new Product[]{second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneName() {
        String text = "Iphone10";

        Product[] actual = productManager.searchBy(text);
        Product[] expected = new Product[]{third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneVendor() {
        String text = "Xiaomi";

        Product[] actual = productManager.searchBy(text);
        Product[] expected = new Product[]{forth};
        assertArrayEquals(expected, actual);
    }

}
