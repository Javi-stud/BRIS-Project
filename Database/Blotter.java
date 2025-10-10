import java.sql.*;
import java.util.Scanner;

public class Blotter {

    public static void main ( String [] args ) {

        Scanner scan = new Scanner(System.in);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/systemdb","root","clydelimbaga123");
           
            System.out.print("Enter First Name of Complainant >> ");
            String complainantFirst = scan.nextLine();

            System.out.print("Enter Middle Name of Complainant (Leave Blank if None) >> ");
            String complainantMiddle = scan.nextLine();

            System.out.print("Enter Last Name of Complainant >> ");
            String complainantLast = scan.nextLine();

            System.out.print("Enter the Age of Complainant >> ");
            String complainantAge = scan.nextLine();

            System.out.print("Enter the Civil Status of Complainant >> ");
            String complainantCivilStatus = scan.nextLine();

            System.out.print("Enter Complainant Address >> ");
            String complainantAddress = scan.nextLine();

            System.out.print("Enter the First Name of the Respondent that is Blottered >> ");
            String complainedFirst = scan.nextLine();

            System.out.print("Enter the Middle Name of the Respondent that is Blottered (Leave Blank if None)>> ");
            String complainedMiddle = scan.nextLine();

            System.out.print("Enter the Last Name of the Respondent thats is Blottered >> ");
            String complainedLast = scan.nextLine();

            System.out.print("Enter the Age of the Respondent Complained >> ");
            String complainedAge = scan.nextLine();

            System.out.print("Enter the Civil Status of the Respondent Complained >> ");
            String complainedCivilStatus = scan.nextLine();

            System.out.print("Enter the Address of the Respondent Complained >> ");
            String complainedAddress = scan.nextLine();

            System.out.print("Enter Statement of Complain >> ");
            String statementOfComplain = scan.nextLine();

            System.out.print("Enter the Action Taken >> ");
            String actionTaken = scan.nextLine();

            System.out.print("Enter Location of Incidence >> ");
            String locationOfIncidence = scan.nextLine();

            System.out.print("Enter the Date of Complain ( YYYY-MM-DD ) >> ");
            String dateOfComplain = scan.nextLine();

            System.out.print("Status: (Pending, Active, Resolved, or Referred) >> ");
            String blotterStatus = scan.nextLine();
           
            String insertQuery = "INSERT INTO blotter (complainant_first_name, complainant_middle_name, complainant_last_name, complainant_age, complainant_civil_status, complainant_address, blottered_first_name, blottered_middle_name, blottered_last_name, complained_age, complained_civil_status, complained_address, statement_of_complain, action_taken, location_of_incidence, date_of_complain, blotter_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(insertQuery);
            pstmt.setString(1, complainantFirst);
            pstmt.setString(2, complainantMiddle);
            pstmt.setString(3, complainantLast);
            pstmt.setString(4, complainantAge);
            pstmt.setString(5, complainantCivilStatus);
            pstmt.setString(6, complainantAddress);
            pstmt.setString(7, complainedFirst);
            pstmt.setString(8, complainedMiddle);
            pstmt.setString(9, complainedLast);
            pstmt.setString(10, complainedAge);
            pstmt.setString(11, complainedCivilStatus);
            pstmt.setString(12, complainedAddress);
            pstmt.setString(13, statementOfComplain);
            pstmt.setString(14, actionTaken);
            pstmt.setString(15, locationOfIncidence);
            pstmt.setString(16, dateOfComplain);
            pstmt.setString(17,blotterStatus);


        
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Blotter Filed Successfully");
            } else {
                System.out.println("Not Successful");
            }

            pstmt.close();
            con.close();

        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scan.close();
        }

    }
    
}
