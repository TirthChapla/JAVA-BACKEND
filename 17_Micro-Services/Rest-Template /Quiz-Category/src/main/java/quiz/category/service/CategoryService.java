package quiz.category.service;


import org.springframework.stereotype.Service;
import quiz.category.dto.CategoryDto;

import javax.xml.catalog.Catalog;
import java.util.List;

@Service
public interface CategoryService
{

    public List<CategoryDto> getAllCategory();

    public CategoryDto addCategory(CategoryDto categoryDto);

    public CategoryDto getcategoryByID(String id);

    public CategoryDto updateCategory(CategoryDto categoryDto , String id);

    public String deleteCategory(String id);

}
