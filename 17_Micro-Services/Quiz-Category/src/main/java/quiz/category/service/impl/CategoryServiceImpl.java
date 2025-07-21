package quiz.category.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import quiz.category.dto.CategoryDto;
import quiz.category.entities.Category;
import quiz.category.repositories.CategoryRepo;
import quiz.category.service.CategoryService;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService
{

    CategoryRepo categoryRepo;
    ModelMapper modelMapper;


    public CategoryServiceImpl(CategoryRepo categoryRepo, ModelMapper modelMapper) {
        this.categoryRepo = categoryRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CategoryDto> getAllCategory()
    {
        List<Category> categoryList = categoryRepo.findAll();

        List<CategoryDto> categoryDtoList = categoryList
                                            .stream()
                                            .map(category -> modelMapper.map(category, CategoryDto.class)).toList();

        return categoryDtoList;
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto)
    {
        Category category = modelMapper.map(categoryDto , Category.class);

        Category savedCategory = categoryRepo.save(category);

        return modelMapper.map(savedCategory,CategoryDto.class);
    }

    @Override
    public CategoryDto getcategoryByID(String id) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto , String id)
    {
        Category category = modelMapper.map(categoryDto ,Category.class);

        Category updateCategory  =categoryRepo.findById(id).orElseThrow();

        updateCategory.setActive(category.isActive());
        updateCategory.setDescription(category.getDescription());
        updateCategory.setTitle(category.getTitle());

        return modelMapper.map(updateCategory , CategoryDto.class);
    }

    @Override
    public String deleteCategory(String id)
    {
         categoryRepo.deleteById(id);

        return "Category Deleted Successfully";
    }
}
