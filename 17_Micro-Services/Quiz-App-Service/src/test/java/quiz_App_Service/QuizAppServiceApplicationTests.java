package quiz_App_Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import quiz_App_Service.dto.CategoryDto;
import quiz_App_Service.service.CategoryFeignSercice;

import java.util.List;

@SpringBootTest
class QuizAppServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	CategoryFeignSercice categoryFeignSercice;

	@Test
	public  void testFeignGetAllCategories()
	{
		System.out.println("Getting All the categories");

		List<CategoryDto> list = categoryFeignSercice.findAll();

		list.forEach(categoryDto ->{

			System.out.println(categoryDto.getTitle());
		});
	}

	@Test
	public  void testFeignGetCategorieById()
	{
		System.out.println("Getting the categories By id");

		CategoryDto categoryDto = categoryFeignSercice.findById("java1");

		System.out.println(categoryDto.getTitle());
	}

	@Test
	public  void testFeignDeleteCategorieById()
	{
		System.out.println("Getting delete  categories By id");

		String s = categoryFeignSercice.deleteById("java1");

		System.out.println(s);
	}

	@Test
	public  void testFeignUpdateCategorieById()
	{
		System.out.println("Getting update categories By id");

		CategoryDto categoryDto = new CategoryDto("eng1","English Speaking","speaking english is very easy",true);

		CategoryDto categoryDto1 = categoryFeignSercice.updateById("java1", categoryDto);

		System.out.println(categoryDto1.getTitle()+"/n"+categoryDto1.getDescription());
	}

}
