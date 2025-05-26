package many_to_many.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jpa_category")
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cid;

    @Column(nullable = false)
    String title;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    (
        name = "product_category",
        joinColumns = @JoinColumn(name = "p_id"),
        inverseJoinColumns = @JoinColumn(name = "c_id")
    )
    List<Product> products= new ArrayList<>();

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
