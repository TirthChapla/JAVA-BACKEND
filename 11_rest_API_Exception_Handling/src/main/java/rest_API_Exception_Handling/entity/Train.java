package rest_API_Exception_Handling.entity;

public class Train 
{
    String trainNumber;
    String trainName;
    int capacity;

    public Train(String number, String expressTrain, int i)
    {
        this.trainNumber = number;
        this.trainName = expressTrain;
        this.capacity = i;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
