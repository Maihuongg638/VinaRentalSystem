
import java.io.*; 

import java.util.*;

public class Branch implements SimpleKey, Serializable
{
  private String branchNr;
  private String name;
  private Set<Branch> listNeibouringBranch;
  private String address;
  private String phoneNr;
  public Branch(String branchNr,  String name, String address, String phoneNr)
  {
    this.branchNr = branchNr;
    listNeibouringBranch = new HashSet<Branch>();
    this.name = name;
    this.address = address;
    this.phoneNr = phoneNr;
  }
  public Set<Branch> getlistNeibouringBranch(){
    return listNeibouringBranch;
  }
  public String toString()
  {
    return  "\n\tBranch[branchNr: " + branchNr + ", name: " + name + ", address : " + address + ", phoneNr: " + phoneNr  + "]"; 
  }
  public String getKey()
  {
    return branchNr;
  }
  public void addNeighborBranch(Branch branch)
  {
    listNeibouringBranch.add(branch);
  }
}