import java.io.*; 

public class Car implements SimpleKey, Serializable
{
  private String regNr;
  private String color;
  private String residingbranchNr;
  private CarStatus carStatus;
  private String carModelNr;
  private Integer yearOfProduct;
  private String carTypeID;
  private String carGroupN;
  private CarRentalGroup carGroup;

  public Car(String regNr, String color, String residingbranchNr, Integer yearOfProduct, String carModelNr, String carTypeID, String carGroupN)
  {
    this.regNr = regNr;
    this.color = color;
    this.residingbranchNr = residingbranchNr;
    this.carModelNr = carModelNr;
    this.yearOfProduct = yearOfProduct;
    this.carTypeID = carTypeID;
    this.carGroupN = carGroupN;
  }
  public String toString()
  {
    return  "\n\tCar[regNr: " + regNr + ", color: " + color + ", branch : " + residingbranchNr + ", carStatus: " + carStatus + ", carModel: " + carModelNr + ", yearOfProduct : " + yearOfProduct + ", carTypeID: " + carTypeID + ", carGroup: " + carGroup + "]"; 
  }
  public String getKey()
  {
    return regNr;
  }
  public CarStatus getCarStatus()
  {
    return carStatus;
  }
  public String getResidingBranch()
  {
    return  residingbranchNr;
  }
  public void setResidingBranch(String residingbranchNr)
  {
    this.residingbranchNr = residingbranchNr;
  }
  public CarRentalGroup getCarGroup()
  {
    return  new CarRentalGroup(NameCarGroup.valueOf(carGroupN));
  }
  public String getNameCarRentalGroup()
  {
    return  carGroupN;
  }
  public void setCarStatus(CarStatus carStatus)
  {
    this.carStatus = carStatus;
  }
}