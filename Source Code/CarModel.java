import java.io.*; 

public class CarModel implements SimpleKey, Serializable
{
  private String modelNr;
  private String shortDescription;
  private String control;
  private Double petrolConsumption;
  private int numberOfDoor;
  private String carGroup;
  public CarModel(String modelNr, String shortDescription, String control, Double petrolConsumption, int numberOfDoor, String carGroup)
  {
    this.modelNr = modelNr;
    this.shortDescription = shortDescription;
    this.control = control;
    this.petrolConsumption = petrolConsumption;
    this.numberOfDoor = numberOfDoor;
    this.carGroup = carGroup;
  }

  public String toString()
  {
    return  "\n\tCarModel[modelNr: " + modelNr + ", shortDescription: " + shortDescription + ", control : " + control + ", petrolConsumption: " + petrolConsumption + ", numberOfDoor: " + numberOfDoor + ", carGroup: " + carGroup + "]"; 
  }
  public String getKey()
  {
    return modelNr;
  }
}