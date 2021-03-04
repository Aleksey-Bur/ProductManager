package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerEmptyTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book first = new Book(1, "War And Peace", 100, "Lev Tolstoy");

    @Test
    void shouldGetAll() {
        Product[] actual = repository.findAll();
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByInEmpty() {
        String text = "War And Peace";
        Product[] actual = manager.searchBy(text);
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByInOneItem() {
        String text = "War And Peace";
        manager.add(first);
        Product[] actual = manager.searchBy(text);
        Product[] expected = new Product[]{first};
        assertArrayEquals(expected, actual);
    }
}
