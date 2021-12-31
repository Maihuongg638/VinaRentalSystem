import java.io.*; 

public class Customer implements SimpleKey, Serializable
{
  private int id;
  private String lastName;
  private String firstName;
  private String driverLicense;
  private String phoneNr;
  private String email;
  public Customer(int id, String lastName, String firstName, String driverLicense, String phoneNr, String email)
  {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.driverLicense = driverLicense;
    this.phoneNr = phoneNr;
    this.email = email;
  }

  public String toString()
  {
    return  "\n\tCustomer[id: " + id + ", first name: " + firstName + ", last Name : " + lastName + ", driverLicenseNumber: " + driverLicense + ", phoneNr: " + phoneNr + ", email: " + email + "]"; 
  }
  public String getKey()
  {
    return driverLicense;
  }
}