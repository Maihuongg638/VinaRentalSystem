
import java.util.*;
import java.text.SimpleDateFormat;  

public class VinaRentalSystem {
  private Set<Branch> branchList;
  private Set<CarModel> carModelList;
  private Set<Car> carList;
  private Set<Customer> customerList;
  private Set<Customer> discountCustomerList;
  private Set<Customer> blackList;
  private Set<Rental> rentalList;
  private Set<CarRentalGroup> carRentalGroupList;


  public VinaRentalSystem() {
    customerList = new HashSet<Customer>();
    branchList = new HashSet<Branch>();
    carModelList = new HashSet<CarModel>();
    carList = new HashSet<Car>();
    discountCustomerList = new HashSet<Customer>();
    blackList = new HashSet<Customer>();
    rentalList = new HashSet<Rental>();
    carRentalGroupList = new HashSet<CarRentalGroup>();
  }
  public void addNewRental(Rental r)
  {
    rentalList.add(r);
  }
  public String toString() {
    String desc = "VinaRentalSystem[" + 
      "\n  branchList: " + branchList +
      "\n  carModelList: " + carModelList +
      "\n  carList: " + carList +
      "\n  rentalList: " + rentalList +
      "\n  customerList: " + customerList + 
      "\n  discountCustomerList: " + discountCustomerList +
      "\n  blackList: " + blackList +
      "\n].";
    return desc;
  }
 // build the prototype for use case 1: Add a branch to the branch list
  public void addBranch(String branchNr, String name, String address, String phoneNr)  throws Exception {
    Branch branch = (Branch) Helper.search(branchList, branchNr);
    boolean pre = branch == null;
    if (!pre) {
      throw new Exception(" Cannot add the branch into the system since the  branch ID : " + branchNr + " already existed in the system!");
    }
    branch = new Branch(branchNr, name, address, phoneNr);
    branchList.add(branch);
    System.out.println( branch.toString() + " has been add successfully!!!");
    
  }
  // build the prototype for use case 2:  Make a pair of branches neighbors to each other.
  public void createPairBranch(String branchNr1, String branchNr2, String startDate, String startTime, String endDate, String endTime)  throws Exception {
    Branch branch1 = (Branch) Helper.search(branchList, branchNr1);
    boolean pre = branch1 == null;
    //pre1: check whether the first branch number is new or not
    if (pre) {
      throw new Exception(" Cannot create a pair branch into the system since the  branch number : " + branchNr1 + " does not exist in the system!");
    }
    //pre2: check whether the second branch number is new and different with the first one
    Branch branch2 = (Branch) Helper.search(branchList, branchNr2);
    boolean pre2 = branch2 == null;
    if (pre2) {
      throw new Exception(" Cannot create a pair branch into the system since the second branch number : " + branchNr2 + " does not exist in the system!");
    }
    if(branchNr2.equals(branchNr1)){
      throw new Exception(" Cannot create a pair branch into the system since 2 branch number are similar!!!");
    }
    // pre3: Check that  branch2 dose not exist in the neighborlist of branch 1
    if(branch1.getlistNeibouringBranch().contains(branch2))
    {
      throw new Exception("Cannot  create a pair branch into the system since the second branch number " + branchNr2 + "already exist in the neighborlist of branch 1");
    }
    SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy HH:mm");
    long difference_In_Time = sdf.parse(endDate +" " + endTime).getTime() - sdf.parse(startDate+" " + startTime).getTime();
    int hours   = (int) ((difference_In_Time / (1000*60*60)) % 24);
    if(hours >= 12){
      throw new Exception("The time to move cars from branch " +branchNr1+" to branch " + branchNr2 + " is "+ hours + "=> Cannot create a pair branch into the system since the time to move cars from one to another is greater or equals 12 hours!!! ");
    }
    branch1.addNeighborBranch(branch2);
    branch2.addNeighborBranch(branch1);
    System.out.println("Makimg a pair of branches neighbors for branch " +branchNr1+" and branch " + branchNr2 +  " has been add successfully!!!");
  }
  
  public void addCarRentalGroup(String name)  throws Exception {
    // System.out.println("Hello");
    //pre2: check whether the name exists in the NameCarGroup
    if(NameCarGroup.valueOf(name) == null){
      throw new Exception(" Cannot add the car rental group into the system since the  name of group: " + name + " does not exist in the system!");
    }
    CarRentalGroup carRentalGr = new CarRentalGroup(NameCarGroup.valueOf(name));
    carRentalGroupList.add(carRentalGr);
    System.out.println( carRentalGr.toString() + " has been add successfully!!!");
    
  }

  // build the prototype for use case 4: Add a model to the model list
  public void addModel(String modelNr, String shortDesc, String control, Double petrolConsumption, Integer doorNr, String nameGr)  throws Exception {
    CarModel model = (CarModel) Helper.search(carModelList, modelNr);
    boolean pre = model == null;
    //pre1: check whether the model number is new or not
    if (!pre) {
      throw new Exception(" Cannot add the model into the system since the  model number : " + modelNr + " already existed in the system!");
    }
    //pre2: check whether the control exists in the ControlModel
    if(ControlModel.valueOf(control) == null){
      throw new Exception(" Cannot add the model into the system since the  control type : " + control + " does not exist in the system!");
    }
    //pre3: check whether the the car group's type exists in the ControlModel
    if(NameCarGroup.valueOf(nameGr) == null)
    {
      throw new Exception(" Cannot add the model into the system since the car group : " + nameGr + " does not exist in the system!");
    }
    // Create an object model with inspected input parameters:
    model = new CarModel(modelNr,shortDesc, control, petrolConsumption, doorNr, nameGr);
    carModelList.add(model); // add object model into the carModelList
    System.out.println( model.toString() + " has been add successfully!!!"); // confirm success for user by the way print the model information in sreen
    
  }

  // build the prototype for use case 5: Add a car to the model list
  public void addCar(String regNr, String color, String residingbranchNr, Integer productYear, String carModelNr, String carTypeID, String carGroup)  throws Exception {
    Car car = (Car) Helper.search(carList, regNr);
    boolean pre = car == null;
    //pre1: check whether the registration number exist or not
    if (!pre) {
      throw new Exception(" Cannot add the car into the system since the  registration number : " + regNr + " already existed in the system!");
    }
    //pre2: check whether the  carGroup? exists in the system or not
    if(NameCarGroup.valueOf(carGroup) == null)
    {
      throw new Exception(" Cannot add the model into the system since the car group : " + carGroup + " does not exist in the system!");
    }
    //pre3: check whether the  residing branch exists in the branchList or not
    Branch branch = (Branch) Helper.search(branchList, residingbranchNr);
    boolean pre2 = branch == null;
    //pre1: check whether the registration number exist or not
    if (pre2) {
      throw new Exception(" Cannot add the car into the system since the  residing branch number : " + residingbranchNr + " does not exist in the branchList!");
    }

    // Create an object car with inspected input parameters:
    car = new Car(regNr,color, residingbranchNr, productYear, carModelNr, carTypeID, carGroup);
    carList.add(car); // add object car into the carModelList
    System.out.println( car.toString() + " has been add successfully!!!"); // confirm success for user by the way print the car information in sreen
    
  }

  // build the prototype for use case 6: Add a customer to the customer list
  public void addCustomer(String lastName, String firstName, String driverLicense, String phoneNr, String email)  throws Exception {
    Customer customer = (Customer) Helper.search(customerList, driverLicense);
    boolean pre = customer == null;
    if (!pre) {
      throw new Exception(" Cannot add the customer since the driver License number: " + driverLicense + " already registered in the system!");
    }
    customer = new Customer(customerList.size() + 1, lastName, firstName, driverLicense, phoneNr, email);
    customerList.add(customer);
    System.out.println( customer.toString() + " has been add successfully!!!");
    
  }
  // build the prototype for use case 7: List cars that are available at a specified branch and belong to a specified rental group (do not include the cars at neighbor branches)
  public void listCarOfBranch(String branchNr, String nameRentalGr)  throws Exception {
    //pre1: check whether the branchNr exists in the branchList 
    Branch branch = (Branch) Helper.search(branchList, branchNr);
    boolean pre = branch == null;
    if (pre) {
      throw new Exception(" Cannot print any car from the system since the branch Nr : " + branchNr + " does not exist in the system!");
    }
    //pre2: check whether the nameRentalGr exists in the CarRentalGroupList
    if(NameCarGroup.valueOf(nameRentalGr) == null){
      throw new Exception(" Cannot print any car from the system since the  name of group: " + nameRentalGr + " does not exist in the system!");
    }
    
    System.out.println("List of car belongs to barnch : " + branchNr + " and has name car rental group: "+ nameRentalGr + " are: \n");
    for (Car element : carList) {
      if(element.getResidingBranch().equals(branchNr) && element.getNameCarRentalGroup().equals(nameRentalGr))
      {
        System.out.println(element.toString());
      }
    }
  }




  // build the prototype for use case 8: TEST FOR USE CASE 8: RECORD THE RETURN OF A CAR
  // String rentalNr, Double endMillage,String returnBranch, String returnDate, String returnTime
  public void recordReturnCar(String rentalNr, Double endMillage, String returnBranch, String returnDate, String returnTime)  throws Exception {
    Rental rental = (Rental) Helper.search(rentalList, rentalNr);
    boolean pre = rental == null;
    if (pre) {
      throw new Exception(" Cannot record the rental since the rental number: " + rentalNr + " does not exist in the system!");
    }
    
    // Check if the return branch is different with pickup branch, we will update residing branch of this car into return branch
    if(!returnBranch.equals(rental.getPickupBranch()))
    {
      Car car = (Car) Helper.search(carList, rental.getRegNr());
      car.setCarStatus(CarStatus.RETURNED);
      if(!car.getResidingBranch().equals(returnBranch))  
      {
        car.setResidingBranch(returnBranch);
      }
    }
    rental.RecordRental(rentalNr, endMillage, returnBranch, returnDate, returnTime);
    rental.setRentalStatus(RentalStatus.RETURNED); // set status of rental become RETURNED
    System.out.println( rental.toString() + " has been record successfully!!!");
    
  }

  
}