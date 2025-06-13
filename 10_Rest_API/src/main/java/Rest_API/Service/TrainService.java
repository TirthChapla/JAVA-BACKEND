package Rest_API.Service;

import Rest_API.entity.Train;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrainService
{
    private final List<Train> trainList = new ArrayList<>(List.of(
            new Train("12345", "Express Train", 500),
            new Train("67890", "Local Train", 300)
    ));

    //✅ GET ALL TRAINS
    public List<Train> getAllTrains()
    {
        return this.trainList;
    }

    //✅ GET ONE TRAIN
    public Optional<Train> getOneTrain(String trainNo)
    {
        return this.trainList.stream().filter(train-> train.getTrainNumber().equals(trainNo)).findFirst();
    }

    //✅ ADD TRAIN
    public String addTrain(Train train)
    {
        this.trainList.add(train);

        return "Train added SuccessFully";
    }

    //✅ Delete TRAIN
    public String deleteTrain(String trainNo)
    {
        boolean removed = this.trainList.removeIf(train -> train.getTrainNumber().equals(trainNo));

        if (removed) {
            return "Train Deleted Successfully";
        } else {
            return "Train not found";
        }
    }





}
