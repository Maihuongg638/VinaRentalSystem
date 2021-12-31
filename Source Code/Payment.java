
import java.io.*; 

public class Payment implements SimpleKey, Serializable
{
  private String rentalNr;
  private Double amount;
  private PaymentMethod method;
  private PaymentItem item;
  public Payment(String rentalNr,  Double amount, PaymentMethod method, PaymentItem item)
  {
    this.rentalNr = rentalNr;
    this.amount = amount;
    this.method = method;
    this.item = item;
  }
  public String toString()
  {
    return  "\n\tPayment[rentalNr: " + rentalNr + ", amount: " + amount + ", method : " + method + ", item: " + item  + "]"; 
  }
  public String getKey()
  {
    return rentalNr;
  }
}