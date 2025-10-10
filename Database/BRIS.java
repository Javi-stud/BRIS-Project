
import java.sql.*;
import java.util.Scanner;
public class BRIS {

    public static void main ( String[] args ){
    
        Scanner scan = new Scanner(System.in);
        boolean cont = false;
        
        try {


            System.out.print("Enter Username >> ");
            String username = scan.nextLine();
            System.out.print("Enter Password >> ");
            String password = scan.nextLine();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/systemdb","root","clydelimbaga123");
            String inputQuery = "SELECT * FROM user_login WHERE username = ? AND password = ?";
            PreparedStatement log = con.prepareStatement(inputQuery);
            log.setString(1, username);
            log.setString(2, password);

            ResultSet rs = log.executeQuery();

            if (rs.next()) {
                System.out.println();
                System.out.println("Login Successful");
                cont = true;
            } else {
                System.out.println();
                System.out.println("Invalid Username or Password");
            }
            
            if ( cont ) {
            System.out.println();
            System.out.println("Add New Resident");
            System.out.print("Enter New Resident Last Name >> ");
            String lastName = scan.nextLine();
            
            System.out.print("Enter New Resident First Name >> ");
            String firstName = scan.nextLine();
            
            System.out.print("Enter New Resident Middle Name >> ");
            String middleName = scan.nextLine();
            
            System.out.print("Enter New Resident Suffix >> ");
            String suffix = scan.nextLine();
            
            System.out.print("Male or Female >> ");
            String sex = scan.nextLine();
            
            System.out.print("Birthdate: YYYY-MM-DD >> ");
            String birthdate = scan.nextLine();
            
            System.out.print("Enter Resident Age >> ");
            int age = scan.nextInt();
            scan.nextLine();
            
            System.out.print("Status: Single, Married, Widowed, or Separated >> ");
            String civilStatus = scan.nextLine();
            
            System.out.print("Enter Residents Sitio in Barangay >> ");
            String sitio = scan.nextLine();
            
            System.out.print("Enter Occupation >> ");
            String occupation = scan.nextLine();
            
            System.out.print("Enter Contact Number >> ");
            String contactNumber = scan.nextLine();
            
            System.out.print("Enter Email Address >> ");
            String emailAddress = scan.nextLine();
            
            System.out.print("Enter Voter Status ( Registered, Not Registered ) >> ");
            String voterStatus = scan.nextLine();
            
            System.out.print("Enter Number of People in the Household >> ");
            String numHousehold = scan.nextLine();
            
            boolean senior = age >= 60;
            
            System.out.print("Enter 1 is the resident died or 0 when is still alive >> ");
            String deceased = scan.nextLine();

            System.out.print("Enter Religion >> ");
            String religion = scan.nextLine();

            System.out.print("Is the resident part of PWD (yes or no)>> ");
            String PWD = scan.nextLine();
            if (PWD == "yes") {
                PWD = "1";
            } else {
                PWD = "0";
            }

            
            String insertQuery = "INSERT INTO residents_details (last_name, first_name, middle_name, suffix, sex, birthdate, age, civil_status, sitio, occupation, contact_number, email_address, voter_status, no_household, senior, deceased, religion, PWD)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(insertQuery);
            pstmt.setString(1, lastName);
            pstmt.setString(2, firstName);
            pstmt.setString(3, middleName);
            pstmt.setString(4, suffix);
            pstmt.setString(5, sex);
            pstmt.setDate(6, Date.valueOf(birthdate));
            pstmt.setInt(7, age);
            pstmt.setString(8, civilStatus);
            pstmt.setString(9, sitio);
            pstmt.setString(10, occupation);
            pstmt.setString(11, contactNumber);
            pstmt.setString(12, emailAddress);
            pstmt.setString(13, voterStatus);
            pstmt.setString(14, numHousehold);
            pstmt.setBoolean(15, senior);
            pstmt.setString(16, deceased);
            pstmt.setString(17, religion);
            pstmt.setString(18, PWD);

            


            int rows = pstmt.executeUpdate();
            
            if (rows > 0) {
                System.out.println("Resident inserted successfully.");
            } else {
                System.out.println("not succesful");
            }
            
            
            
            pstmt.close();
            con.close();
            /*ResultSet rs=stmt.executeQuery("SELECT " + select + " FROM residents_details");
            while (rs.next())
            {
                System.out.println(rs.getString(select));
            }
            con.close();*/
        }else {
            System.out.println();
        }
    }
        catch(Exception e) 
        {
            System.out.println("Error: " + e.getMessage());
        }finally {
            scan.close();
    }

    }
    }
    
