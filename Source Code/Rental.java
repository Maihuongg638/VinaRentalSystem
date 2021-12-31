import java.io.*; 
import java.util.*;
import java.text.SimpleDateFormat;  

public class Rental implements SimpleKey, Serializable
{
  private String rentalNr;
  private Double startMillage;
  private Double endMillage; 
  private String regNr;
  private String returnBranch;
  private String pickupBranch;
  private Date pickupDate;
  private Date pickupTime;
  private Date returnTime;
  private Date returnDate;
  private RentalStatus status;

  // Contructor when there is customer pick a car
  public Rental(String rentalNr,String regNr, Double startMillage,String pickupBranch, String pickupDate, String pickupTime, RentalStatus status)  throws Exception
  {
    this.rentalNr = rentalNr;
    this.regNr = regNr;
    this.startMillage = startMillage;
    this.pickupBranch = pickupBranch;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
    this.pickupDate = sdf.parse(pickupDate);
    this.pickupTime = new SimpleDateFormat("HH:mm").parse(pickupTime);
    this.status = status;
  }
  // Contructor when the customer return car
  public void RecordRental(String rentalNr, Double endMillage,String returnBranch, String returnDate, String returnTime)  throws Exception
  {
    this.rentalNr = rentalNr;
    this.endMillage = endMillage;
    this.returnBranch = returnBranch;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
    this.returnDate = sdf.parse(returnDate);
    this.returnTime = new SimpleDateFormat("HH:mm").parse(returnTime);
  }

  public String toString()
  {
    return  "\n\tRental[rentalNr: " + rentalNr + ", startMillage: " + startMillage + ", pickupBranch : " + pickupBranch + ", returnBranch: " + returnBranch + ", pickupDate: " + pickupDate + ", returnDate : " + returnDate + ", pickupTime: " + pickupTime + ", returnTime: " + returnTime + ", status: " + status + "]"; 
  }
  public String getKey()
  {
    return rentalNr;
  }
  public RentalStatus getRentalStatus()
  {
    return status;
  }
  public String getPickupBranch()
  {
    return pickupBranch;
  }
  public String getRegNr()
  {
    return regNr;
  }
  public void setRentalStatus(RentalStatus status)
  {
    this.status = status;
  }
}