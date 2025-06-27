package File_Uploding.controllers;

import File_Uploding.entity.Human;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/humans")
public class HumanController
{

    @GetMapping
    public List<Human> getAllHumans()
    {
        List<Human> humans = List.of(new Human("Tirth"), new Human("Harsh"));

        return humans;
    }
}
