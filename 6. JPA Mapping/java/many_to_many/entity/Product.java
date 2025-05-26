package many_to_many.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="jpa_product")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int pid;

    @Column(nullable = false)
    String name;

    @ManyToMany(mappedBy = "products" , cascade = CascadeType.ALL)
    List<Category> categories= new ArrayList<>();


    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
