package quiz_App_Service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quiz_App_Service.dto.QuizDto;
import quiz_App_Service.service.QuizService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quizzes")
public class QuizController {

    private  final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    //create quiz
    @PostMapping
    public ResponseEntity<QuizDto> create(@RequestBody QuizDto quizDto){
        return new ResponseEntity<>(quizService.create(quizDto), HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{quizId}")
    public ResponseEntity<QuizDto> update(@PathVariable("quizId") String quizId, @RequestBody QuizDto quizDto){
        return new ResponseEntity<>(quizService.update(quizId, quizDto), HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{quizId}")
    public ResponseEntity<Void> delete(@PathVariable("quizId") String quizId){
        quizService.delete(quizId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //get all
    @GetMapping
    public ResponseEntity<List<QuizDto>> findAll(){
        return new ResponseEntity<>(quizService.findAll(), HttpStatus.OK);
    }

    //get by id
    @GetMapping("/{quizId}")
    public ResponseEntity<QuizDto> findById(@PathVariable("quizId") String quizId)
    {
        /// ✅✅ We use here REST-TEMPLATE here to make interservice connection

        return new ResponseEntity<>(quizService.findById(quizId), HttpStatus.OK);
    }

    //get by category
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<QuizDto>> findByCategory(@PathVariable("categoryId") String categoryId) {
        return new ResponseEntity<>(quizService.findByCategory(categoryId), HttpStatus.OK);
    }
}
