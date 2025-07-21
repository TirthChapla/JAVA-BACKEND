package quiz.category.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quiz.category.dto.CategoryDto;
import quiz.category.entities.Category;
import quiz.category.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController
{

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public ResponseEntity<List<CategoryDto>> getallCategoriy()
    {
        List<CategoryDto> categoryDtoList = categoryService.getAllCategory();

        return new ResponseEntity<>(categoryDtoList , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable String id)
    {
        CategoryDto categoryDtos = categoryService.getcategoryByID(id);

        return new ResponseEntity<>(categoryDtos , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory( @RequestBody CategoryDto categoryDto)
    {
        CategoryDto categoryDto1 = categoryService.addCategory(categoryDto);

        return new ResponseEntity<>(categoryDto1 , HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> upadtCategory(@RequestBody CategoryDto categoryDto ,@PathVariable String id)
    {
        CategoryDto categoryDto1 = categoryService.updateCategory(categoryDto , id);

        return new ResponseEntity<>(categoryDto1 , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable String id)
    {
        String mes  = categoryService.deleteCategory(id);

        return new ResponseEntity<>(mes , HttpStatus.OK);
    }

}
