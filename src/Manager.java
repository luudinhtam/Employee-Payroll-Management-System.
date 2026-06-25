
import Core.EmployeeList;
import Tool.ConsoleInputter;

/**
 *
 * @author acer
 */
public class Manager {
    public static void main(String[] args) {
        
        // Khai bao ten va dinh dang cua Employee File
        String emFile = "employees.txt";
        
        // Danh sach Employee phai co truoc
        EmployeeList emList = new EmployeeList();
        emList.readFile(emFile); // Doc file chua thong tin ve cac Employee
        
        // Các mục menu chép từ đề bài
        String[] options = {
                "Load employee data from file",
                "Add a new employee",
                "Update employee information", 
                "Remove an employee by ID",
                "Search employees by attribute",
                "Calculate monthly payroll",
                "Display employee list",
                "Save data to file", 
                "Quit program"
        };

        boolean changed = false;

        int choice = 0;

        
        do {
            System.out.println("\n ===== Employee Payroll Management System ===== \n");
            choice = ConsoleInputter.intMenu(options);
            switch (choice) {
                
                case 1: // Load employee data from file
                    
                    if(changed == true) {
                        boolean loadResp = ConsoleInputter.getBoolean("Clear all current data and load data again? Y/N");                        
                        if (loadResp == true) {
                            emList.readFile(emFile);
                            System.out.println("Load data successfully!");
                        }
                    }
                    else {
                        emList.readFile(emFile);
                        System.out.println("Load data successfully!");
                    }
                    break;
                    
                case 2: // Add a new employee
                    changed = true;
                    emList.addEmployee();
                    break;
                
                case 3: // Update employee information
                    changed = true;
                    emList.updateEmployee();
                    break;
                    
                case 4: // Remove an employee by ID
                    changed = true;
                    emList.removeEmployeeById();
                    break;
                    
                case 5: // Search employees by attribute
                    emList.searchEmployeesByAttribute();
                    break;
                    
                case 6: // Calculate monthly payroll
                    emList.calculateMonthlyPayroll();
                    break;
                    
                case 7: // Display employee list
                    emList.display();
                    break;
                
                case 8: // Save data to file
                    emList.saveToFile(emFile);
                    
                    System.out.println("Data has been saved!");
                    break;
                
                case 9: // Quit program
                    if (changed == true) {
                        boolean resp = ConsoleInputter.getBoolean("Save changes on Employee List? Y/N");
                        if (resp == true) {
                            emList.saveToFile(emFile);
                            System.out.println("Data has been saved!");
                        }   
                    }
                    
                    System.out.println("Good Bye! See you again...");
            }
        } while (choice >= 1 && choice < options.length);
        
        
        
        
    }
}
