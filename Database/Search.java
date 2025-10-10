import java.sql.*;
import java.util.Scanner;

public class Search {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/systemdb", "root", "clydelimbaga123" );

            System.out.println("Enter Ways To Search: ");
            System.out.println("1. Search By Resident's by ID");
            System.out.println("2. Search By Resident's by Last Name");
            System.out.println("3. Search By Resident's by Sex");
            System.out.println("4. Search By Resident's by Civil Status");
            System.out.println("5. Search By Resident's by Sitio");
            System.out.println("6. Search By Resident's by Voter Status");
            System.out.println("7. Search Senior Residents");
            System.out.println("8. Search Deceased Residents");
            System.out.println("9. Search By Resident's by Religion");
            System.out.println("10. Search PWD");
            System.out.print(">> ");
            int look = scan.nextInt();
            scan.nextLine();
            
            if ( look == 1 ) {
                System.out.print("Enter Resident's ID to Search >> ");
                int value = scan.nextInt();
                String query = "SELECT * FROM residents_details where residents_id = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setInt(1, value);
                ResultSet rs = pstmt.executeQuery();
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.println();
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

                if (!found) {
                    System.out.println("No Residents");
                }
                rs.close();
                pstmt.close();
            } else if ( look == 2 ) {
                System.out.print("Enter Resident's Last Name to Search >> ");
                String value = scan.nextLine();
                String query = "SELECT * FROM residents_details where last_name = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, value);
                ResultSet rs = pstmt.executeQuery();
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    
                    System.out.println();
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

                if (!found) {
                    System.out.println("No Residents");
                }
                rs.close();
                pstmt.close();
            } else if ( look == 3 ) {
                System.out.print("Enter Resident's Sex to Search >> ");
                String value = scan.nextLine();
                String query = "SELECT * FROM residents_details where sex = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, value);
                ResultSet rs = pstmt.executeQuery();
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    
                    System.out.println();
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

                if (!found) {
                    System.out.println("No Residents");
                }
                rs.close();
                pstmt.close();
            } else if ( look == 4 ) {
                System.out.print("Enter Resident's Civil Status to Search >> ");
                String value = scan.nextLine();
                String query = "SELECT * FROM residents_details where civil_status = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, value);
                ResultSet rs = pstmt.executeQuery();
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.println();
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

                if (!found) {
                    System.out.println("No Residents");
                }
                rs.close();
                pstmt.close();
            } else if ( look == 5 ) {
                System.out.print("Enter Resident's Sitio to Search >> ");
                String value = scan.nextLine();
                String query = "SELECT * FROM residents_details where sitio = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, value);
                ResultSet rs = pstmt.executeQuery();
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.println();
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

                if (!found) {
                    System.out.println("No Residents");
                }
                rs.close();
                pstmt.close();
            } else if ( look == 6 ) {
                System.out.print("Enter Resident's Civil Status to Search >> ");
                String value = scan.nextLine();
                String query = "SELECT * FROM residents_details where civil_status = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, value);
                ResultSet rs = pstmt.executeQuery();
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.println();
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

                if (!found) {
                    System.out.println("No Residents");
                }
                rs.close();
                pstmt.close();
            } else if ( look == 7 ) {
                
                String query = "SELECT * FROM residents_details where age >= 60";
                PreparedStatement pstmt = con.prepareStatement(query);
                
                ResultSet rs = pstmt.executeQuery();
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.println();
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

                if (!found) {
                    System.out.println("No Residents");
                }
                rs.close();
                pstmt.close();
            } else if ( look == 8 ) {
                
                String query = "SELECT * FROM residents_details where deceased = 1";
                PreparedStatement pstmt = con.prepareStatement(query);
                
                ResultSet rs = pstmt.executeQuery();
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.println();
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

                if (!found) {
                    System.out.println("No Residents");
                }
                rs.close();
                pstmt.close();
            } else if ( look == 9 ) {
                System.out.print("Enter Resident's Religion to Search >> ");
                String value = scan.nextLine();
                String query = "SELECT * FROM residents_details where religion = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, value);
                ResultSet rs = pstmt.executeQuery();
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.println();
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

                if (!found) {
                    System.out.println("No Residents");
                }
                rs.close();
                pstmt.close();
            } else if ( look == 10 ) {
               
                String query = "SELECT * FROM residents_details where PWD = 1";
                PreparedStatement pstmt = con.prepareStatement(query);
                
                ResultSet rs = pstmt.executeQuery();
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.println();
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
                    System.out.println("Deceased: " + rs.getString("deceased"));
                    System.out.println("Religion: " + rs.getString("religion"));
                    System.out.println("PWD: " + rs.getString("PWD"));
                }

                if (!found) {
                    System.out.println("No Residents");
                }
                rs.close();
                pstmt.close();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scan.close();
        }
    }
}
