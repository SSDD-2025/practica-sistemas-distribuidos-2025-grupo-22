package codigo.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Component
public class DatabaseInitializer {

    @Autowired
    private ShopService shopService;

    @Autowired
    private BookService bookService;

    @Autowired
	private ImageUtils imageUtils;

    @PostConstruct
    public void init() throws IOException {

        // Create some shops
        Shop shop1 = new Shop("Casa del Libro", "C.Gran Vía, 29, Centro, 28013 Madrid");
		Shop shop2 = new Shop("FNAC", "C. de Preciados, 28, Centro, 28013 Madrid");
        Shop shop3 = new Shop("El Corte Inglés Callao", "Pl. del Callao, 2, Centro, 28013 Madrid");

        shopService.save(shop1);
        shopService.save(shop2);
        shopService.save(shop3);

        List<Long> set1 = List.of(shop1.getId(), shop2.getId(), shop3.getId());
        List<Long> set2 = List.of(shop1.getId(), shop2.getId());
        List<Long> set3 = List.of(shop1.getId(), shop3.getId());
        List<Long> set4 = List.of(shop2.getId(), shop3.getId());

        

        // Create some books
        Book quijote = new Book("El Quijote",
                "Alonso Quijano es un hidalgo -es decir, un noble sin bienes y de escala social baja-, de unos cincuenta años, que vive en algún lugar de La Mancha a comienzos del siglo XVII.", 1605, "ES");
        saveBookWithURLImage(quijote,set1,"quijote.jpg");

        Book hobbit = new Book("El Hobbit",
                "La historia comienza un día en el que el hobbit Bilbo Bolsón, habitante de la Comarca, recibe la inesperada visita del mago.", 1937, "ES");
        saveBookWithURLImage(hobbit, set2,"hobbit.jpg");

        Book harryPotter = new Book("Harry Potter and the Philosopher's Stone",
            "Harry Potter is a series of seven fantasy novels written by British author J. K. Rowling.", 1997, "EN");
        saveBookWithURLImage(harryPotter, set3, "harrypotter.jpg");

        Book lordOfTheRings = new Book("The Lord of the Rings",
            "The Lord of the Rings is an epic high fantasy novel written by English author and scholar J. R. R. Tolkien.", 1954, "EN");
        saveBookWithURLImage(lordOfTheRings,set4,"lotr.jpg");

        Book twok = new Book("The Way of Kings", "A new epic fantasy series from the New York Times bestselling author chosen to complete Robert Jordan's The Wheel of Time(R) Series", 2010, "EN");
        saveBookWithURLImage(twok,set1,"wok.jpg");        
    }

    private Book saveBookWithURLImage(Book book, List<Long> selectedShops, String image) throws IOException {
		book.setImageFile(imageUtils.localImageToBlob("images/" + image));
		return bookService.save(book, selectedShops, null);
	}

}