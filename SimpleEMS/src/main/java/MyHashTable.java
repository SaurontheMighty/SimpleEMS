//938081
import java.util.*;

public class MyHashTable {
	
	// ATTRIBUTES
	// buckets is an array of ArrayList.  Each item in an ArrayList is a StudentInfo
	// object holding a reference value pointing to a student.

	public ArrayList<EmployeeInfo>[] buckets;
	private int numInHashTable;

	
	// CONSTRUCTOR

	public MyHashTable(int howManyBuckets) {
		
		numInHashTable=0;
		
		// Construct the hash table (open hashing/closed addressing) as an array of howManyBuckets ArrayLists.

		// Instantiate buckets as an array to have an ArrayList as each element of the array.
		buckets = new ArrayList[howManyBuckets];

		// For each element in the array, instantiate its ArrayList.
		for (int i = 0; i < howManyBuckets; i++) {
			buckets[i] = new ArrayList<EmployeeInfo>();  // Instantiate the ArrayList for bucket i.
		}
	}


	// METHODS
	// All the functions make use of the other functions of the hash table to reduce code redundancy.
	public int getNumInHashTable() {
		return numInHashTable;
	}
	

	public int calcBucket(int studentNumber) {
		return(studentNumber % buckets.length); //calcBucket uses the hashing algorithm in this case modulus to decide the bucket.
	}


	public boolean addEmployee(EmployeeInfo theEmployee) {
		// Add the student referenced by theStudent to the hash table.
		if(theEmployee!=null) {
			int proposedBucket = calcBucket(theEmployee.getEmpNum());
			boolean status = buckets[proposedBucket].add(theEmployee); //addToTable adds the user to the appropriate bucket which it finds by calling calcBucket.
			if(status==true){
                            numInHashTable = numInHashTable+1;
                        }
                        return status;
		}
		else {
			return false;
		}
	}

	

	public EmployeeInfo removeEmployee(int EmployeeNumber) {
		// Remove that student from the hash table and return the reference value for that student.
		// Return null if that student isn't in the table.
		
		if(isInTable(EmployeeNumber)==true) { //It is only possible to remove an employee from the table if they are in the table.
			
			int proposedBucket = calcBucket(EmployeeNumber); // Creating a separate variable to store the bucket so that it's easier to read.
			
			EmployeeInfo removedStudentsReference = getFromTable(EmployeeNumber); //Get the reference number before removing the employee so that it can be returned to the caller.
			
			buckets[proposedBucket].remove(removedStudentsReference); //The remove function of an arrayList can be used to remove the item given it's reference value.
			
                        numInHashTable = numInHashTable-1;
			
                        return removedStudentsReference; 
		}
		else {
			return null;
		}
	}
	
	
	public EmployeeInfo getFromTable(int EmployeeNumber) { //Allows you to search the hash table for an employee with their employee number
		// Return the reference value for that student, return null if student isn't in the table.
		
		int proposedBucket = calcBucket(EmployeeNumber);
		
		for(int i=0; i<buckets[proposedBucket].size(); i++) { //Goes through every item in the arrayList
			
			if(buckets[proposedBucket].get(i).getEmpNum()==EmployeeNumber) { //If the item at that position is the item we're looking for 
				
				return buckets[proposedBucket].get(i); //return its reference value to the caller
				
			}
		}
		
		return null; //If it isn't in the table return null to the caller
		
	}

	public boolean isInTable(int studentNumber) {
		// Return true if that student is in the hash table, false otherwise.

		if(getFromTable(studentNumber)!=null) { //If the student's data can be retrieved from the table then we know that the student is in the table
			
			return true;
		}
		
		else {
			
			return false;
		}
	}
	
	
	public EmployeeInfo searchByName(String firstName,String lastName) { //Search for an employee using their full name
		
		for(int i=0; i<buckets.length; i++) { //Go through every single bucket
			
			for(int j=0; j<buckets[i].size(); j++) { //Go through every single item in the arrayList
				
				if(buckets[i].get(j).getFirstName()==firstName && buckets[i].get(j).getLastName()==lastName) {
					
					return buckets[i].get(j); //This is the employee you are looking for(These are not the droids you are looking for)
				}
				
			}
		}
		return null;
	}


	public void displayTable() {
		// Display all the items in the table in some
		// systematic way.
		
		if(numInHashTable==0) {
			System.out.println("The Hash Table is Empty!");
		}
		else {
			System.out.println("The Hash Table has "+numInHashTable+" employees: ");
                        int n=1;		//To add indexes
			for(int i=0; i<buckets.length; i++) { //Go through every single bucket

				for(int j=0; j<buckets[i].size(); j++) { //Go through every single item in the arrayList
					
					System.out.println(n+": "+(buckets[i].get(j)).getFirstName()+" "+buckets[i].get(j).getLastName()+", Employee Number: "+buckets[i].get(j).getEmpNum());
                                        n=n+1;
				}
			}
		}
	}


}