import java.sql.*;
import java.util.Scanner;

public class editResident {
    
    public static void main ( String [] args ) {

        Scanner scan = new Scanner(System.in);
        boolean edit = true;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/systemdb","root","clydelimbaga123");
            
            System.out.println("Edit a Resident");
            System.out.print("Enter First Name of Resident >> ");
            String editFirstName = scan.nextLine();

            System.out.print("Enter Middle Name of Resident >> ");
            String editMiddleName = scan.nextLine();

            System.out.print("Enter Last Name of Resident >> ");
            String editLastName = scan.nextLine();


            
            while ( edit ) {
                System.out.println("Choose What to Edit");
                System.out.println();
                System.out.println("1. Last Name");
                System.out.println("2. Middle Name");
                System.out.println("3. Civil Status");
                System.out.println("4. Occupation");
                System.out.println("5. Contact Number");
                System.out.println("6. Email Address");
                System.out.println("7. Voter Status");
                System.out.println("8. Number of Household");
                System.out.println("9. Deceased");
                System.out.println("10. Religion");
                System.out.println("11. PWD Condition");
                System.out.println("12. Senior");
                System.out.println(">> ");
                int choice = scan.nextInt();
                scan.nextLine();

                if ( choice == 1) {
                    System.out.print("Enter New Last Name >> ");
                    String editProfile = scan.nextLine();
                    String editQuery = "UPDATE residents_details SET last_name = ? WHERE first_name = ? AND middle_name = ? AND last_name = ?";
                    PreparedStatement pstmt = con.prepareStatement(editQuery);
                    pstmt.setString(1, editProfile);
                    pstmt.setString(2, editFirstName);
                    pstmt.setString(3, editMiddleName);
                    pstmt.setString(4, editLastName);
                    pstmt.executeUpdate();
                    edit = false;
                    pstmt.close();
                    con.close();

                } else if ( choice == 2 ) {
                    System.out.print("Enter New Middle Name >> ");
                    String editProfile = scan.nextLine();
                    String editQuery = "UPDATE residents_details SET middle_name = ? WHERE first_name = ? AND middle_name = ? AND last_name = ?";
                    PreparedStatement pstmt = con.prepareStatement(editQuery);
                    pstmt.setString(1, editProfile);
                    pstmt.setString(2, editFirstName);
                    pstmt.setString(3, editMiddleName);
                    pstmt.setString(4, editLastName);
                    pstmt.executeUpdate();
                    edit = false;
                    pstmt.close();
                    con.close();
                } else if ( choice == 3 ) {
                    System.out.print("Enter New Civil Status >> ");
                    String editProfile = scan.nextLine();
                    String editQuery = "UPDATE residents_details SET civil_status = ? WHERE first_name = ? AND middle_name = ? AND last_name = ?";
                    PreparedStatement pstmt = con.prepareStatement(editQuery);
                    pstmt.setString(1, editProfile);
                    pstmt.setString(2, editFirstName);
                    pstmt.setString(3, editMiddleName);
                    pstmt.setString(4, editLastName);
                    pstmt.executeUpdate();
                    edit = false;
                    pstmt.close();
                    con.close();
                } else if ( choice == 4 ) {
                    System.out.print("Enter New Occupation Name >> ");
                    String editProfile = scan.nextLine();
                    String editQuery = "UPDATE residents_details SET occupation = ? WHERE first_name = ? AND middle_name = ? AND last_name = ?";
                    PreparedStatement pstmt = con.prepareStatement(editQuery);
                    pstmt.setString(1, editProfile);
                    pstmt.setString(2, editFirstName);
                    pstmt.setString(3, editMiddleName);
                    pstmt.setString(4, editLastName);
                    pstmt.executeUpdate();
                    edit = false;
                    pstmt.close();
                    con.close();
                }else if ( choice == 5 ) {
                    System.out.print("Enter New Contact Number Name >> ");
                    String editProfile = scan.nextLine();
                    String editQuery = "UPDATE residents_details SET contact_number = ? WHERE first_name = ? AND middle_name = ? AND last_name = ?";
                    PreparedStatement pstmt = con.prepareStatement(editQuery);
                    pstmt.setString(1, editProfile);
                    pstmt.setString(2, editFirstName);
                    pstmt.setString(3, editMiddleName);
                    pstmt.setString(4, editLastName);
                    pstmt.executeUpdate();
                    edit = false;
                    pstmt.close();
                    con.close();
                }
            }

            

            
        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scan.close();
        }
    }

}
