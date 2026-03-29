import java.sql.*; // IMPORTING EVERYTHING INSIDE THE SQL PACKAGE
import java.util.*; // IMPORTING EVERYTHING INSIDE THE UTIL PACKAGE

public class main {
    private static final String url = "jdbc:mysql://localhost:3306/"; // URL TO CONNECT WITH MYSQL DATABASE
    private static final String username = "jdbc_fop"; // USERNAME FOR THE DATABASE
    private static final String password = "mysqlpassword999@"; // PASSWORD FOR THE DATABASE

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // STEP 1 : CONNECT IDE TO DATABSE
        // we downloaded the mysqlconnector j from browser and added it to library
        // throught classpath

        // STEP 2 : LOAD DRIVER
        // Class is a built in class and forname is a method which means find a class by
        // the name given.
        // com is company , mysql is package , cj is connector , jdbc is sub package ,
        // Driver is actual class name
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("error in loading MySQL Driver : " + e.getMessage());
        }

        try {
            // STEP 3 : CREATE CONNECTION
            // Connection is Interface , conn is variable , DriverManager is class,
            // getConnection is method of it.
            Connection conn = DriverManager.getConnection(url, username, password);

            // STEP 4 : CREATE STATEMENT
            // Statement is Interface , st is variable , conn is Connection object,
            // CreateStatement is method which returns new statement object.
            Statement st = conn.createStatement();

            // STEP 5 : CREATE DATABASE
            String db_name = "jdbcfop";
            String db_query = "CREATE DATABASE IF NOT EXISTS " + db_name;

            st.executeUpdate(db_query);

            // STEP 6 : SWITCH TO THE DATABASE CREATED
            st.executeUpdate("USE " + db_name);

            // =================================================================================================================================

            // CREATING TABLE IN DATABASE

            String table_query = "CREATE TABLE IF NOT EXISTS students ( id INT PRIMARY KEY NOT NULL, name VARCHAR(50) NOT NULL , age INT NOT NULL , roll INT NOT NULL)";
            st.executeUpdate(table_query);

            // =================================================================================================================================

            // ADDING DUMMY VALUES IN DATA BASE USING PREPARED STATEMENT

            // TABLE WITH FIXED VALUES

            // String insert_query = "INSERT INTO students(name,age,roll) VALUES(?,?,?)";
            // PreparedStatement ps = conn.prepareStatement(insert_query);
            // ps.setString(1, "Pranav");
            // ps.setInt(2, 19);
            // ps.setInt(3, 54);
            // int a1 = ps.executeUpdate();
            // if (a1 != 0) {
            // System.out.println("value added in students database");
            // }

            // ------------------------------------------------------------------------------------------------------------------------------------------

            // TABLE TAKING INPUT FROM USER AND USING BATCH PROCESSING

            String query_insert = "INSERT INTO students(name,age,roll) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query_insert);
            while (true) {

                System.out.println("enter name :");
                String s = sc.next();
                System.out.println("enter age :");
                int a = sc.nextInt();
                System.out.println("enter roll :");
                int r = sc.nextInt();
                System.out.print("do you want to add more (Y/N) :");
                String choice = sc.next();

                ps.setString(1, s);
                ps.setInt(2, a);
                ps.setInt(3, r);
                ps.addBatch();

                if (choice.toUpperCase().equals("N")) {
                    break;
                }
            }
            // BATCH PROCESSING
            int[] batchResults = ps.executeBatch();
            for (int i = 0; i < batchResults.length; i++) {
                System.out.printf("Row %d: %d changes made%n", i + 1, batchResults[i]);
            }

            // ===================================================================================================================================

            // DELETING VALUES IN DATABASE USING PREPARED STATEMENTS

            // String delete_query = " DELETE FROM students WHERE id = ?";
            // PreparedStatement ps1 = conn.prepareStatement(delete_query);
            // ps1.setInt(1, 1);
            // int a2 = ps1.executeUpdate();
            // if (a2 != 0) {
            // System.out.println("value added in students database");
            // }

        } catch (SQLException e) {
            System.out.println("error : " + e.getMessage());

        }

    }

}
