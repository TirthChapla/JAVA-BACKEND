package quiz_App_Service.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import quiz_App_Service.collections.Quiz;
import quiz_App_Service.dto.CategoryDto;
import quiz_App_Service.dto.QuizDto;
import quiz_App_Service.repositories.QuizRepository;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class QuizServiceImpl implements QuizService {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(QuizServiceImpl.class);

    private final QuizRepository quizRepository;

    private final ModelMapper modelMapper;

    private final RestTemplate restTemplate;

    private final WebClient webClient;

    private final WebClient.Builder webClientBuilder;

    private final CategoryFeignSercice categoryFeignSercice;

    //constructor        UREKA for the passing the URl
    public QuizServiceImpl(QuizRepository quizRepository,
                           ModelMapper modelMapper,
                           RestTemplate restTemplate,
                           WebClient.Builder webClientBuilder,
                           CategoryFeignSercice categoryFeignSercice)
    {

        this.quizRepository = quizRepository;
        this.modelMapper = modelMapper;
        this.restTemplate = restTemplate;
        this.webClientBuilder = webClientBuilder;
        this.categoryFeignSercice = categoryFeignSercice;


        ///✅✅ here we are using UREKA for the passing the URl in form of the servide name.

        this.webClient = webClientBuilder.baseUrl("http://QUIZ-CATEGORY").build();

    }


    @Override      ///  ✅✅ We use REST-TEMPLATE at here
    public QuizDto create(QuizDto quizDto) {

        Quiz quiz = modelMapper.map(quizDto, Quiz.class);
        quiz.setId(UUID.randomUUID().toString());

        //✅✅Note String url is commented here we used it for REST TEMPLATE ❌❌
        // We have SERVICE REGISTRATORY which maintain the urls for the servies
        // so wo dont have to provide the static URL's
        //And
        // now we are using Load Balancer


        // validate category:
        //String url = "http://localhost:9091/api/v1/categories/" + quizDto.getCategoryId();


        String url = "lb://QUIZ-CATEGORY/api/v1/categories/" + quizDto.getCategoryId();       //or
//        String url = "http://QUIZ-CATEGORY/api/v1/categories/" + quizDto.getCategoryId();
        logger.info(url);
        // call to category service
        CategoryDto category = restTemplate.getForObject(url, CategoryDto.class);
        logger.info("category exists: " + category.getTitle());

        Quiz savedQuiz = quizRepository.save(quiz);
        QuizDto quizDto1 = modelMapper.map(savedQuiz, QuizDto.class);
        quizDto1.setCategoryDto(category);
        return quizDto1;

    }

    @Override
    public QuizDto update(String quizId, QuizDto quizDto) {
        Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.setTitle(quizDto.getTitle());
        quiz.setDescription(quizDto.getDescription());
        quiz.setMaxMarks(quizDto.getMaxMarks());
        quiz.setTimeLimit(quizDto.getTimeLimit());
        quiz.setCreatedBy(quizDto.getCreatedBy());
        quiz.setNoOfQuestions(quizDto.getNoOfQuestions());
        quiz.setImageUrl(quizDto.getImageUrl());
        quiz.setLive(quizDto.getLive());
        quiz.setPassingMarks(quizDto.getPassingMarks());
        quiz.setCategoryId(quizDto.getCategoryId());
        Quiz updatedQuiz = quizRepository.save(quiz);
        QuizDto quizDto1 = modelMapper.map(updatedQuiz, QuizDto.class);
        return quizDto1;


    }

    @Override
    public void delete(String quizId) {
        Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quizRepository.delete(quiz);
    }

    @Override     ///  ✅✅ We use WEB-CLIENT at here
    public List<QuizDto> findAll()
    {
        ///  ✅✅ We use WEB-CLIENT at here

        List<Quiz> all = quizRepository.findAll();

        List<QuizDto> quizDtoList = all.stream().map(quiz->{

            String categoryID = quiz.getCategoryId();
            QuizDto quizDto = modelMapper.map(quiz,QuizDto.class);
                try
                {
                    CategoryDto categorydto = this.webClient
                            .get()
                            .uri("/api/v1/categories/{categoryID}" , categoryID)
                            .retrieve()
                            .bodyToMono(CategoryDto.class)
                            .block();


                    quizDto.setCategoryDto(categorydto);
                }
                catch (WebClientResponseException e)
                {
                    e.printStackTrace();
                    quizDto.setCategoryDto(null);
                }
            return quizDto;

        }).toList();

        return quizDtoList;
    }

    @Override
    public QuizDto findById(String quizId) {
        Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz not found"));

        ///  ✅✅ We use REST-TEMPLATE at here

        QuizDto quizDto = modelMapper.map(quiz, QuizDto.class);
        String categoryId = quiz.getCategoryId();
        String url = "lb://QUIZ-CATEGORY/api/v1/categories/" + categoryId;
//        String url = "http://QUIZ-CATEGORY/api/v1/categories/" + categoryId;
        logger.info(url);
        // call to category service
        CategoryDto category = restTemplate.getForObject(url, CategoryDto.class);
        quizDto.setCategoryDto(category);
        return quizDto;
    }

    @Override     ///  ✅✅ We use FEIGN-CLIENT at here
    public List<QuizDto> findByCategory(String categoryId) {
        List<Quiz> all = quizRepository.findByCategoryId(categoryId);

        return all.stream().map(quiz -> {

            QuizDto quizDto = modelMapper.map(quiz, QuizDto.class);

            CategoryDto categoryDto = categoryFeignSercice.findById(quizDto.getCategoryId());

            quizDto.setCategoryDto(categoryDto);

            return quizDto;

        }).toList();


    }
}