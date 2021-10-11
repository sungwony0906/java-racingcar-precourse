package racinggame.model;

public class Car implements Model{

    private String carName;

    public Car(String carName){
        this.carName = carName;
    }

    public String getCarName(){
        return this.carName;
    }
}
