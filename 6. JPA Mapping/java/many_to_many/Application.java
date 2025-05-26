package many_to_many;

import many_to_many.entity.Category;
import many_to_many.entity.Product;
import many_to_many.repository.CategoryRepo;
import many_to_many.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    CategoryRepo categoryRepo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Override
    public void run(String... args) throws Exception
    {
        Category c1 = new Category();
        c1.setTitle("Treanding");

        Category c2 = new Category();
        c2.setTitle("Mobile");

        Product p1 = new Product();
        p1.setName("Hp victus");

        Product p2 = new Product();
        p2.setName("Samsung s25 fe");


        p2.getCategories().add(c1);
        p2.getCategories().add(c2);

        c1.getProducts().add(p1);
        p1.getCategories().add(c1);


        c1.getProducts().add(p2);
        c2.getProducts().add(p2);

        productRepo.save(p1);
        productRepo.save(p2);

    }

}
