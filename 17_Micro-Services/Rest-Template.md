# Rest Template  Inter Service Connection


## How to use ?


* I am getting the quiz by the quizId.
* With the following I want Category of the quiz.
* But my Category is present in the other project.


### Steps to use Rest Template:

* Get the path on which the category will I get.
* Run both the porject together.
* Give the request form the postman


## ProjectConfig.java

    @Configuration
    public class ProjectConfig
    {
        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }


## QuizServiceImpl.java

        @Override
        public QuizDto create(QuizDto quizDto) 
        {

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

## QuizController.java



    //get by id
    @GetMapping("/{quizId}")
    public ResponseEntity<QuizDto> findById(@PathVariable("quizId") String quizId)
    {
        /// ✅✅ We use here REST-TEMPLATE here to make interservice connection

        return new ResponseEntity<>(quizService.findById(quizId), HttpStatus.OK);
    }