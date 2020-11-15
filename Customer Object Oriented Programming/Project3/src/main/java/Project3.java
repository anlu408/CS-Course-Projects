import java.util.*; //Import to scan in info

public class Project3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in); //Create a Scanner to take info
        
        //Variable definition
        String fn, ln, com, choice;
        int id;
        double balance;
        //Unable to get bash to read javac command.
        //To resolve this I used user input to set array size.
        int size;
        
        
        //Temporary Code to take array size
        System.out.println("Enter Array Size: ");
        size = in.nextInt();
        //Array to store data
        Customer [] list = new Customer[size];
        //Array to hold ids to binary search for duplicates
        int [] idList = new int[size];
        
        /*
        Code I tried that did not work. Not sure if due to my implementation
        Or due to the fact that bash is not allowing me to use the javac 
        command
        int size = Integer.parseInt(args[0]);
        Customer [] c1 = new Customer[size];
        int [] ids = new int[size];
        */
            //Loop to read in FN/LN/Com
            for(int i = 0; i < list.length; i++)
            {
            System.out.println("First Name: ");
            fn = in.next();
            System.out.println("Last Name: ");
            ln = in.next();
            System.out.println("Company: ");
            com = in.next();
            
            //Until a non-duplicate ID is entered continue to read input.
            while (true) 
            {
                //User input for ID
                System.out.println("3-digit ID: ");
                id = in.nextInt();
                
                Arrays.sort(idList); //Innate sort feature in Java
                
                if (Arrays.binarySearch(idList, id) >= 0)//Returns >1 if true
                {
                    System.out.println("Duplicate found. Try again");
                }
                
                else //Returns <0 on false
                {
                    idList[i] = id;
                    break;
                }
            }
            //User input for Balance
            System.out.println("Balance: ");
            balance = in.nextDouble();
            
            Customer c1 = new Customer(fn, ln, com, id, balance);
            list[i] = c1;
            list[i].printInfo(); //Prints info to confirm if correct.
            
            //Checking if User Input is correct
            System.out.println("Is this information correct? y/n ");
            choice = in.next();
            
            //If incorrect + prompt that follows
            if (choice.equalsIgnoreCase("n"))
            {
                System.out.println("Edit Commands");
                System.out.println("F - First Name");
                System.out.println("L - Last Name");
                System.out.println("C - Company");
                System.out.println("B - Balance");
                System.out.println("Command: ");
                choice = in.next();
                
                if(choice.equalsIgnoreCase("F"))
                {
                    System.out.println("New First Name: ");
                    fn = in.next();
                    c1.setFirstName(fn);
                    list[i].printInfoUpdate();
                }
                else if(choice.equalsIgnoreCase("L"))
                {
                    System.out.println("New Last Name: ");
                    ln = in.next();
                    c1.setLastName(ln);
                    list[i].printInfoUpdate();
                }
                else if(choice.equalsIgnoreCase("C"))
                {
                    System.out.println("New Company: ");
                    com = in.next();
                    c1.setCompany(com);
                    list[i].printInfoUpdate();
                }
                else if(choice.equalsIgnoreCase("B"))
                {
                    System.out.println("New Balance: ");
                    balance = in.nextDouble();
                    c1.setBalance(balance);
                    list[i].printInfoUpdate();
                }
            
            /*
            It is fine to use else here as we are assuming all UI is correct.
            If this wasn't the case we would be using the above with Y and 
            Stating else as an error message to loop back to the beginning. 
            */               
            else  
                {
                    continue;
                }
            }
            //Prompt to see if another customer is added
            System.out.println("Add another customer?: ");
            choice = in.next();
            
            //Self explanatory basically the same as above.
            if (choice.equalsIgnoreCase("n"))
            {
                break;
            }
            }
            double total = 0;
            System.out.println("List of Customers ");
            System.out.println("--------------------------------"
                    + "------------------ ");
            
            //Having a bit of trouble with this part as I have no idea how
            //This part actually works. I tried a lot of different things and
            //Found that this snippet of code from the Template was the best
            //to use for this portion of the project.
            for (Customer c : list)
            
            {
                if(c != null) //Definitely have no idea what is going on here.
                {
                    //printInfo's for each customer in list
                    c.printInfo();
                    //Defined total as a double and adds each value of Balance
                    //from each customer into total.
                    total += c.getBalance();
                }
            }
            
            //Formatting to ensure 2 decimal places. I had trouble figuring this
            //out and found that it was just printf to get the job done.
            System.out.printf("Total: $%.2f\n", total);
            
            //Lines as shown in Project Specifications
            System.out.println("------------------------------"
                    + "-------------------- ");
}
}

class Customer //Class Definition
{
    private String firstName;
    private String lastName;
    private String company;
    private int id;
    private double balance;
    
    //Default constructor with no arguments as per Project Specifications
    public Customer()
    {
        this.firstName = "John";
        this.lastName = "Doe";
        this.company = "Generic Co.";
        this.id = 000;
        this.balance = 100;
                
    }
    //Non-Default constructor as per Project Specifications
    public Customer(String fn, String ln, String com, int id, double bl)
    {
        this.firstName = fn;
        this.lastName = ln;
        this.company = com;
        this.id = id;
        this.balance = bl;
    }
    public void setFirstName(String newName) //First name mutator function
    {
        firstName = newName;
    }
            
    public String getFirstName() //First name accessor function
    {
        return firstName;
    }
    
    public void setLastName(String newLastName) //Last name mutator function
    {
        lastName = newLastName;
    }
    public String getLastName() // Last name accessor function
    {
        return lastName;
    }
    public void setCompany(String newCompany) //Company mutator function
    {
        company = newCompany;
    }
    public String getCompany() //Company accessor function
    {
        return company;
    }
    public void setId(int newID) //ID Mutator function
    {
        id = newID;
    }
    public int getId() // ID Accessor funciton
    {
        return id;
    }
    public void setBalance(double newBalance) //Balanace mutator function
    {
        balance = newBalance;
    }
    public double getBalance() //Balance accessor function
    {
        return balance;
    }

    //Prints info as per Project Specifications
    public void printInfo()
    {
        System.out.println(getLastName() + ", " + getFirstName() + " | " 
                + getCompany() + " | " + getId() + " | $" + getBalance());
    }
    
    //Added extra line of code as per Output requirements
    public void printInfoUpdate()
    {
        System.out.println(getLastName() + ", " + getFirstName() + " | " 
                + getCompany() + " | " + getId() + " | $" + getBalance());
        System.out.println("New data updated");
    }
}
