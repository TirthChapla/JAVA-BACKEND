package quiz_App_Service.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import quiz_App_Service.dto.CategoryDto;

import java.util.List;

//name : must be unique for the Feign Client
//url

//@FeignClient(name = "category-service" , url = "http://localhost:9091/api/v1")
//public interface CategoryFeignSercice
//{
//
//    @GetMapping("/categories")
//    List<CategoryDto> findAll();
//
//    @GetMapping("/categories/{categoryId}")
//    CategoryDto findById(@PathVariable String categoryId );
//
//    @DeleteMapping("/categories/{categoryId}")
//    String deleteById(@PathVariable String categoryId);
//
//    @PutMapping("/categories/{categoryId}")
//    CategoryDto updateById(@PathVariable String categoryId , @RequestBody CategoryDto categoryDto);
//}

//❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️        ️With EUREKA And LOAD BALANCER         ❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️

@FeignClient(name = "QUIZ-CATEGORY")
public interface CategoryFeignSercice
{

    @GetMapping("/api/v1/categories")
    List<CategoryDto> findAll();

    @GetMapping("/api/v1/categories/{categoryId}")
    CategoryDto findById(@PathVariable String categoryId );

    @DeleteMapping("/api/v1/categories/{categoryId}")
    String deleteById(@PathVariable String categoryId);

    @PutMapping("/api/v1/categories/{categoryId}")
    CategoryDto updateById(@PathVariable String categoryId , @RequestBody CategoryDto categoryDto);
}
