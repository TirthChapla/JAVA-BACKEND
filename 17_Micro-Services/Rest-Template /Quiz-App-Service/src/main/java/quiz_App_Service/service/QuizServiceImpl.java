package quiz_App_Service.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import quiz_App_Service.collections.Quiz;
import quiz_App_Service.dto.CategoryDto;
import quiz_App_Service.dto.QuizDto;
import quiz_App_Service.repositories.QuizRepository;

import java.util.List;
import java.util.UUID;

@Service
public class QuizServiceImpl implements QuizService {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(QuizServiceImpl.class);

    private final QuizRepository quizRepository;

    private final ModelMapper modelMapper;

    private final RestTemplate restTemplate;

    public QuizServiceImpl(QuizRepository quizRepository, ModelMapper modelMapper, RestTemplate restTemplate) {
        this.quizRepository = quizRepository;
        this.modelMapper = modelMapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public QuizDto create(QuizDto quizDto) {

        Quiz quiz = modelMapper.map(quizDto, Quiz.class);
        quiz.setId(UUID.randomUUID().toString());

        // validate category:
        String url = "http://localhost:9091/api/v1/categories/" + quizDto.getCategoryId();
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

    @Override
    public List<QuizDto> findAll() {
        List<Quiz> all = quizRepository.findAll();
        return all.stream().map(quiz -> modelMapper.map(quiz, QuizDto.class)).toList();
    }

    @Override
    public QuizDto findById(String quizId) {
        Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz not found"));

        QuizDto quizDto = modelMapper.map(quiz, QuizDto.class);
        String categoryId = quiz.getCategoryId();
        String url = "http://localhost:9091/api/v1/categories/" + categoryId;
        logger.info(url);
        // call to category service
        CategoryDto category = restTemplate.getForObject(url, CategoryDto.class);
        quizDto.setCategoryDto(category);
        return quizDto;
    }

    @Override
    public List<QuizDto> findByCategory(String categoryId) {
        List<Quiz> all = quizRepository.findByCategoryId(categoryId);
        return all.stream().map(quiz -> modelMapper.map(quiz, QuizDto.class)).toList();


    }
}