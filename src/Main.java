import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/peopleinfo", "root", "Special@26");
        Statement sta = connection.createStatement();


        while (true) {

            System.out.println("1 Select");
            System.out.println("2 Insert");
            System.out.println("3 Update");
            System.out.println("4 Delete");
            System.out.println("5 EXIT");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            if (n == 1) {

                ResultSet rs = sta.executeQuery("select *  from register");

                while (rs.next()) {

                    System.out.print(rs.getString(1));
                    System.out.print(", " + rs.getString(2));
                    System.out.print(", " + rs.getString(3));
                    System.out.println();
                }
            } else if (n == 2) {
                System.out.println("enter id :");
                int id = sc.nextInt();
                System.out.println("enter email-id ");
                String email = sc.next();
                System.out.println("enter phone number");
                String phone = sc.next();

                System.out.println(id + " " + email + " " + phone);


                int val = sta.executeUpdate("insert into register values(' " + id + " ',' " + email + " ',' " + phone + " ')");
                if (val == 0) {
                    System.out.println("Values can not insert");
                } else {
                    System.out.println("Values added successfully");
                }

            } else if (n == 3) {
                System.out.println("What you want to update\n1-> email\n2-> phone");
                int update = sc.nextInt();
                System.out.println("enter id:");
                int id1 = sc.nextInt();
                if (update == 1) {
                    System.out.println("Enter email : ");
                    String email1 = sc.next();
                    int val = sta.executeUpdate("update register set email=' " + email1 + " ' where id=' " + id1 + " ' ");
                    if (val > 0) {
                        System.out.println("email updated successfully");
                    }

                } else if (update == 2) {
                    System.out.println("Enter phone : ");
                    String phone1 = sc.next();
                    int val = sta.executeUpdate("update register set  phone=' " + phone1 + " ' where id=' " + id1 + " ' ");
                    if (val > 0) {
                        System.out.println("phone updated successfully");
                    }
                }
            } else if (n == 4) {
                System.out.println("Enter id");
                int id1 = sc.nextInt();
                int val = sta.executeUpdate("delete from register where id= ' " + id1 + " ' ");
                if (val == 0) {
                    System.out.println("row can not deleted");


                } else {
                    System.out.println("row delete successfully");
                }
            } else {
                System.out.println("exited");
                break;
            }
        }
    }
}