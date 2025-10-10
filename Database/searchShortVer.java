import java.sql.*;
import java.util.Scanner;

public class searchShortVer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/systemdb", "root", "clydelimbaga123"
            );

            System.out.println("Select Category to Search:");
            System.out.println("1. Search Resident by ID");
            System.out.println("2. Search Resident by Last Name");
            System.out.println("3. Search Residents by Sex");
            System.out.println("4. Search Residents by Civil Status");
            System.out.println("5. Search Residents by Sitio");
            System.out.println("6. Search Residents by Voter Status");
            System.out.println("7. Search Senior Residents");
            System.out.println("8. Search Deceased Residents");
            System.out.println("9. Search Resident by Religion");
            System.out.println("10. Search PWD");
            System.out.print(">> ");
            int look = scan.nextInt();
            scan.nextLine(); 

            PreparedStatement pstmt = null;
            ResultSet rs = null;

            
            if (look == 1) {
                System.out.print("Enter Resident's ID to Search >> ");
                int value = scan.nextInt();
                pstmt = con.prepareStatement("SELECT * FROM residents_details WHERE residents_id = ?");
                pstmt.setInt(1, value);
            } else if (look == 2) {
                System.out.print("Enter Last Name >> ");
                String value = scan.nextLine();
                pstmt = con.prepareStatement("SELECT * FROM residents_details WHERE last_name = ?");
                pstmt.setString(1, value);
            } else if (look == 3) {
                System.out.print("Enter Sex >> ");
                String value = scan.nextLine();
                pstmt = con.prepareStatement("SELECT * FROM residents_details WHERE sex = ?");
                pstmt.setString(1, value);
            } else if ( look == 4 ) {
                System.out.println("Enter Civil Status >> ");
                String value = scan.nextLine();
                pstmt = con.prepareStatement("SELECT * FROM residents_details WHERE civil_status = ?");
                pstmt.setString(1, value);
            } else if ( look == 5 ) {
                System.out.println("Enter Sitio >> ");
                String value = scan.nextLine();
                pstmt = con.prepareStatement("SELECT * FROM residents_details WHERE sitio = ?");
                pstmt.setString(1, value);
            } else if ( look == 6 ) {
                System.out.println("Enter Civil Status >> ");
                String value = scan.nextLine();
                pstmt = con.prepareStatement("SELECT * FROM residents_details WHERE civil_status = ?");
                pstmt.setString(1, value);
            }else if ( look == 7 ) {
                pstmt = con.prepareStatement("SELECT * FROM residents_details WHERE age >= 60");
            } else if ( look == 8 ) {
                pstmt = con.prepareStatement("SELECT * FROM residents_details WHERE deceased = 1");
            } else if ( look == 10 ) {
                pstmt = con.prepareStatement("SELECT * FROM residents_details WHERE PWD = 1");
            } else {
                System.out.println("Invalid option or not yet implemented.");
            }

            if (pstmt != null) {
                rs = pstmt.executeQuery();
                boolean found = false;
                int count = 0;
                
                while (rs.next()) {
                    found = true;
                    count++;
                    System.out.println("");
                    
                    System.out.println("Residents ID: " + rs.getInt("residents_id"));
                    System.out.println("Last Name: " + rs.getString("last_name"));
                    System.out.println("First Name: " + rs.getString("first_name"));
                    System.out.println("Middle Name: " + rs.getString("middle_name"));
                    System.out.println("Suffix: " + rs.getString("suffix"));
                    System.out.println("Sex: " + rs.getString("sex"));
                    System.out.println("Birthdate: " + rs.getDate("birthdate"));
                    System.out.println("Age: " + rs.getInt("age"));
                    System.out.println("Civil Status: " + rs.getString("civil_status"));
                    System.out.println("Sitio: " + rs.getString("sitio"));
                    System.out.println("Occupation: " + rs.getString("occupation"));
                    System.out.println("Contact Number: " + rs.getString("contact_number"));
                    System.out.println("Email Address: " + rs.getString("email_address"));
                    System.out.println("Voter Status: " + rs.getString("voter_status"));
                    System.out.println("Number of Household: " + rs.getString("no_household"));
                    System.out.println("Senior: " + rs.getBoolean("senior"));
                    System.out.println("Deceased: " + rs.getBoolean("deceased"));
                    System.out.println("Religion: " + rs.getString("religion"));
                    System.out.println("PWD: " + rs.getBoolean("PWD"));
                    
                    
                }
                System.out.println("");
                System.out.println("Resident Found (" + count + ")");

                if (!found) {
                    System.out.println("No Residents Found.");
                }

                rs.close();
                pstmt.close();
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scan.close();
        }
    }
}
