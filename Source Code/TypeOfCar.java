
import java.io.*; 

import java.util.*;

public class TypeOfCar implements SimpleKey, Serializable
{
  private String carTypeID;
  private boolean economy;
  private boolean compactCar;
  private boolean mediaSize;
  private boolean fullSize;
  private String stationWagon;
  private boolean Van;
  private boolean fourWeel;
  private boolean sportOrLuxuryCar;

  public TypeOfCar(String carTypeID,boolean economy, boolean compactCar, boolean mediaSize, boolean fullSize, String stationWagon, boolean Van, boolean fourWeel,boolean sportOrLuxuryCar)
  {
    this.carTypeID = carTypeID;
    this.economy = economy;
    this.compactCar = compactCar;
    this.mediaSize = mediaSize;
    this.fullSize = fullSize;
    this.stationWagon = stationWagon;
    this.Van = Van;
    this.fourWeel = fourWeel;
    this.sportOrLuxuryCar = sportOrLuxuryCar;
  }

  public String toString()
  {
    return  "\n\tType Of Car[carTypeID: " + carTypeID + ", economy: " + economy + ", compactCar : " + compactCar + ", mediaSize: " + mediaSize + ", fullSize : " + fullSize + ", stationWagon: " + stationWagon + ", Van: " + Van + ", fourWeel : " + fourWeel + ", sportOrLuxuryCar: " + sportOrLuxuryCar   + "]"; 
  }
  public String getKey()
  {
    return carTypeID;
  }
}