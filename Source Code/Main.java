class Main {
  public static void main(String[] args)throws Exception{
    // create a Vinal Rental System Object
    VinaRentalSystem vnrs = new VinaRentalSystem(); 


    // //  ================ TEST FOR USE CASE 1: ADD A BRANCH ===================
    // //  In this case, we must check the branch number is new or not 
    // Add some branchs to the branchList:
    vnrs.addBranch("b1", "VinFast", "Thu Duc, HCM", "0369872830");
    vnrs.addBranch("b2", "Hyundai Truong Chinh", "Thu Duc, HCM", "0369872834");
    vnrs.addBranch("b3", "Hyundai Truong Chinh", "Thu Duc, HCM", "0369872874");
    vnrs.addBranch("b4", "VinFast", "Distric 7, HCM", "0369872874");

    // try some invalid requests for adding new branch 
    // add customer with the existed branch number in the System
    try 
    { 
      vnrs.addBranch("b1", "MazdaPMH", "Distric 7, HCM", "0369872830");
    } 
    catch(Exception e) 
    { 
      System.out.println(e); 
    }



    //  ======== TEST FOR USE CASE 2: MAKE A PAIR OF BRANCHES NEIGHBORS TO EACH OTHER ========
    // Add some pair of branchs to the branchNeigborList of each branch:
    vnrs.createPairBranch("b1", "b3", "15/10/2021", "16:30", "16/10/2021", "2:10");
    vnrs.createPairBranch("b1", "b2", "22/10/2021", "7:50", "22/10/2021", "10:40");
    vnrs.createPairBranch("b3", "b2", "29/12/2021", "7:50", "30/10/2021", "1:40");
    // try some invalid requests for adding new branch 
    // Add some pair of branchs to the branchNeigborList of each branch with invalid branch number:
    try 
    { 
      vnrs.createPairBranch("b6", "b3", "15/10/2021", "16:30", "16/10/2021", "2:10");
    } 
    catch(Exception e) 
    { 
      System.out.println(e); 
    }
    // Add a pair of branchs to the branchNeigborList of each branch with duplicate branch number:
    try 
    { 
      vnrs.createPairBranch("b3", "b3", "15/10/2021", "16:30", "16/10/2021", "2:10");
    } 
    catch(Exception e) 
    { 
      System.out.println(e); 
    }
    // Add pair of branchs to the branchNeigborList of each branch while they already exist in the branchNeigborList of each other:
    try 
    { 
      vnrs.createPairBranch("b2", "b1", "15/10/2021", "16:30", "16/10/2021", "2:10");
    } 
    catch(Exception e) 
    { 
      System.out.println(e); 
    }
    // Add pair of branchs to the branchNeigborList of each branch while the time to take car forwarding other branch is greater than 12 hours:
    try 
    { 
      vnrs.createPairBranch("b2", "b4", "15/10/2021", "8:30", "16/11/2021", "23:10");
    } 
    catch(Exception e) 
    { 
      System.out.println(e); 
    }




  //  ======== TEST FOR USE CASE 3: ADD A CAR RENTAL GROUP ========
  // Add some valid Rental group to the carRentalGroupList:
  vnrs.addCarRentalGroup("GroupA");
  vnrs.addCarRentalGroup("GroupB");
  vnrs.addCarRentalGroup("GroupC");
  vnrs.addCarRentalGroup("GroupD");
  // // try some invalid requests for adding new branch 
    // // Add a car Rental group with invalid name group in the System
    try 
    { 
      vnrs.addCarRentalGroup("GroupH");
    } 
    catch(Exception e) 
    { 
      System.out.println(e); 
    }




  // //  ================ TEST FOR USE CASE 4: ADD A MODEL ===================
  //   //  In this case, we must check the model number is new or not , whethername car group and type of control are valid
  //   // Add some valid models to the branchList:
    vnrs.addModel("m1", "luxury car!", "automatic", 25.7, 4, "GroupA" );
    vnrs.addModel("m2", "luxury car!", "automatic", 26.0, 4, "GroupB" );
    vnrs.addModel("m3", "sport car!", "automatic", 27.9, 4, "GroupC" );
    vnrs.addModel("m4", "medium truck!", "manual", 26.5, 4, "GroupE" );
    // try some invalid requests for adding new model 
    // pre1: add model with the existed model number in the System
    try 
    { 
      vnrs.addModel("m1", "VinFast car", "manual",  27.9, 4, "GroupE");
    } 
    catch(Exception e) 
    { 
      System.out.println(e); 
    }
    // pre2: add model with invalid control type in the System
    try 
    { 
      vnrs.addModel("m4", "VinFast car", "remotecontrol",  27.9, 4, "GroupC");
    } 
    catch(Exception e) 
    { 
      System.out.println(e); 
    }
    // pre2: add model with invalid car group in the System( car group is arrange from GroupA -> GroupE)
    try 
    { 
      vnrs.addModel("m4", "VinFast car", "manual",  28.2, 4, "GroupF");
    } 
    catch(Exception e) 
    { 
      System.out.println(e); 
    }
    TypeOfCar exellentCar = new TypeOfCar("tc1", true, true, true, false, "stationA6", false, true, true);
    TypeOfCar autoCar = new TypeOfCar("tc2", true, true, true, false, "stationA7", false, false, true);
    TypeOfCar vanCar = new TypeOfCar("tc3", true, true, true, false, "stationA1", true, true, false);
  
  


  //  ================ TEST FOR USE CASE 5: ADD A CAR ===================
    //  In this case, we must check the registration number is new or not , whether residingbranchNr existed in the system and car group is valid
    // Add some valid car requests to the carList:
    vnrs.addCar("r1", "red", "b1", 2020, "m1", "tc1", "GroupA");
    vnrs.addCar("r2", "yellow", "b1", 2021, "m3", "tc1", "GroupA");
    vnrs.addCar("r3", "blue", "b2", 2015, "m4", "tc3", "GroupE");

    // try some invalid requests for adding new car 
    // pre1: add car with the existed registration number in the System
    try 
    { 
      vnrs.addCar("r1", "orange", "b2", 2018, "m4", "tc3", "GroupE");
    } 
    catch(Exception e) 
    { 
      System.out.println(e); 
    }
    // pre2: add car with invalid residing branch number 
    try 
    { 
      vnrs.addCar("r4", "orange", "b3", 2018, "m3", "tc2", "GroupB");
    } 
    catch(Exception e) 
    { 
      System.out.println(e); 
    }
    // pre3: add model with invalid car group in the System( car group is arrange from GroupA -> GroupE)
    try 
    { 
      vnrs.addCar("r5", "white", "b3", 2019, "m3", "tc2",  "GroupF");
    } 
    catch(Exception e) 
    { 
      System.out.println(e); 
    }
    



    //  ================ TEST FOR USE CASE 6: ADD A CUSTOMER ===================
    //  In this case, i assume that the id of customer in the System's customerList is automatically created, the important think we must check is the customer's driver license 
    // Add some customers to the customerList:
    vnrs.addCustomer("Huong", "Nguyen", "12345", "0369872838", "maihuongn638@gmail.com");
    vnrs.addCustomer("Mina", "Nguyen", "12346", "0369872839", "minanguyen638@gmail.com");
    
    // try some invalid requests for adding new customer 
    // add customer with the existed driver license in the System
    try 
    { 
      vnrs.addCustomer("Loc", "Doan", "12345", "0369872831", "doanlocpro638@gmail.com");
    } 
    catch(Exception e) 
    { 
      System.out.println(e); 
    } 



   //  ================ TEST FOR USE CASE 7: List cars that are available at a specified branch and belong to a specified rental group===================

    vnrs.listCarOfBranch("b1", "GroupA");
    vnrs.listCarOfBranch("b2", "GroupE");
  // try some invalid requests for list car of invalid branch
    vnrs.listCarOfBranch("b13", "GroupC");
  // try some invalid requests for list car of invalid group
    vnrs.listCarOfBranch("b3", "GroupM");





  //  ================ TEST FOR USE CASE 8: RECORD THE RETURN OF A CAR===================

    Rental rental1 = new Rental("rt1", "r1", 52.0, "b2", "15/10/2021", "17:30", RentalStatus.RESERVED);
    Rental rental2 = new Rental("rt2", "r2", 108.0, "b1", "15/11/2021", "14:30", RentalStatus.RESERVED);
    Rental rental3 = new Rental("rt3", "r3", 87.0, "b2", "27/12/2021", "8:10", RentalStatus.RESERVED);
    vnrs.addNewRental(rental1);
    vnrs.addNewRental(rental2);
    vnrs.addNewRental(rental2);

    // Record some returning car requests valid:
    vnrs.recordReturnCar("rt1", 176.5, "b2", "18/10/2021", "8:00");
    vnrs.recordReturnCar("rt2", 365.5, "b1", "21/11/2021", "14:20");

    // try some invalid requests for Recording some returning car requests 
    // the request gives a rental number not exist in the retal list
    try 
    { 
      vnrs.recordReturnCar("rt10", 176.5, "b2", "18/10/2021", "8:00");
    } 
    catch(Exception e) 
    { 
      System.out.println(e); 
    } 



    
    // uses the generic search on composite key
    System.out.println("\n ============== The vinarental system includes ============== \n");
    System.out.println(vnrs); 

  }
}