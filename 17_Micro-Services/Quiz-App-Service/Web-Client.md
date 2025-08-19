# Web Client InterService Connection



### Depedency in pom.xml (Quiz-App-Service)

* This provide Non-Blocking Nature


    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-webflux</artifactId>
    </dependency>


### ProjectConfig.java
  
* We have to configure the WebClient 


    import org.modelmapper.ModelMapper;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.web.client.RestTemplate;
    import org.springframework.web.reactive.function.client.WebClient;
    
    @Configuration
    public class ProjectConfig
    {
        @Bean
        public WebClient webClient()
        {
            return WebClient
                    .builder()
                    .baseUrl("http://localhost:9091")
                    .build();
        }
    }


### QuizServiceImpl.java

* This is the logic of the web client.

        @Override
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
