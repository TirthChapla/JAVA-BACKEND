package Jpa_Criteria_API.repository;


import Jpa_Criteria_API.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>
{}
