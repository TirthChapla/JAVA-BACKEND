package Rest_API.controllers;

import Rest_API.Service.TrainService;
import Rest_API.entity.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trains")
public class TrainController
{
    //❤️❤️❤️❤️ Not Recomended Way to Create Rest API's 🔥

//    @RequestMapping("/get-all-trains")
//    public List<Train> getAllTrains() {
//
//
//        List<Train> trainList = List.of(
//            new Train("12345", "Express Train", 500),
//            new Train("67890", "Local Train", 300)
//        );
//
//        return trainList;
//    }

    //❤️❤️❤️❤️ Most Recomended way to Create Rest API's

    @Autowired
    TrainService trainService;

    //✅ GET ALL TRAINS

    @GetMapping
    public List<Train> getAllTrains()
    {
        return trainService.getAllTrains();
    }

//    //✅ GET ONE TRAIN
//
//    @GetMapping("/{trainNo}/{trainName}")
//    public Optional<Train> getOneTrain(@PathVariable("trainNo") String trainNumber , @PathVariable String trainName)
//    {
//        return trainService.getOneTrain(trainNo);
//    }

    //✅ GET ONE TRAIN

    @GetMapping("/{trainNo}")
    public Optional<Train> getOneTrain(@PathVariable String trainNo)
    {
        return trainService.getOneTrain(trainNo);
    }

    //✅ ADD TRAIN

    @PostMapping("/trains")
    public String addTrain(@RequestBody Train train)
    {

        return trainService.addTrain(train);
    }

    //✅ Delete TRAIN
    @DeleteMapping("/{trainNo}")
    public String deleteTrain(@PathVariable String trainNo)
    {

        return trainService.deleteTrain(trainNo);
    }




}
