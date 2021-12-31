import java.io.*; 

public class CarRentalGroup implements  Serializable
{
  private NameCarGroup name;
  private Double rentalPrice;
  public CarRentalGroup(NameCarGroup name)
  {
    this.name = name;
  }

  public String toString()
  {
    return  "\n\tCarGoup[name: " + name + ", rentalPrice: " + rentalPrice + "]"; 
  }
  public Double getRentalPrice()
  {
    return rentalPrice;
  }
  public NameCarGroup getNameCarGroup()
  {
    return name;
  }
  public void setRentalPrice(NameCarGroup name)
  {
    if(name.equals(NameCarGroup.GroupA))
    {
      rentalPrice = 25.0;
    }
    else if(name.equals(NameCarGroup.GroupB))
    {
      rentalPrice = 24.0;
    }
    else if(name.equals(NameCarGroup.GroupC))
    {
      rentalPrice = 23.0;
    }
    else if(name.equals(NameCarGroup.GroupD))
    {
      rentalPrice = 21.5;
    }
    else
    {
      rentalPrice = 18.5;
    }
  }
}