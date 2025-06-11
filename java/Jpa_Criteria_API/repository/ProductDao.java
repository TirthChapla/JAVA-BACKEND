package Jpa_Criteria_API.repository;

import Jpa_Criteria_API.entity.Category;
import Jpa_Criteria_API.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao
{
    //✅ 1. Creating EntityManager

    @Autowired
    private EntityManager entityManager;

    public void getProduct()
    {
        //✅ 2. Creating CriteriaBuilder

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        //✅ 3. Creating CriteriaQuery

        CriteriaQuery<Product>  criteriaQuery = criteriaBuilder.createQuery(Product.class);

        //✅ 4. Creating Root

        Root<Product> root= criteriaQuery.from(Product.class);

        //✅ 5. Creating Predicate : used to create conditons

        Predicate predicate = criteriaBuilder.equal(root.get("name") , "Hp victus");


        ////👇 : this will print all the product pid > 2
        Predicate predicate1 = criteriaBuilder.greaterThan(root.get("pid") , 2);

        ////👇 : Like this we and AND more then two predicates also
        ////👇 : Create complex query...
        Predicate andPredicate = criteriaBuilder.and(predicate,predicate1);


        //✅ 6. Creating Finalize Query
        criteriaQuery.select(root).where(predicate);


        //✅ 7. Retrivig the data from DB

        List<Product> products = entityManager.createQuery(criteriaQuery).getResultList();

        products.forEach(product -> {
            System.out.println(product.getName());
        });


    }

    public void getJoinQuery()
    {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);

        Root<Product> root = criteriaQuery.from(Product.class);

         root.fetch("categories",JoinType.LEFT);

        criteriaQuery.select(root);

        List<Product> resultList = entityManager.createQuery(criteriaQuery).getResultList();

        resultList.forEach(product -> {
            String categoryTitles = product.getCategories().stream()
                    .map(Category::getTitle)
                    .toList()
                    .toString();
            System.out.println(product.getName() + " : " + categoryTitles);
        });

    }


}
