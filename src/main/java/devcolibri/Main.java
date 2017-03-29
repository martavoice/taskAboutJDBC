package devcolibri;


import java.sql.*;

/**
 * Created by Марта on 27.03.2017.
 */
public class Main {
    private final static String URL =
            "jdbc:mysql://localhost:3306/mydbtest";
    private final static String URLFIXED =
            "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
                    "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";
    public static void main(String[] args) {
    Connection connection ;
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);

            }
        catch(SQLException e) {
            System.out.println("Something wrong");
        }
        try {
            connection = DriverManager.getConnection(URLFIXED,USERNAME,PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet set = statement.executeQuery("select * from users");
            while (set.next()){
              User user = new User();
                user.setId(set.getInt(1));
                user.setName(set.getString(2));
                user.setAge(set.getInt(3));
                user.setEmail(set.getString(4));
                System.out.println(user);
            }
        }catch (SQLException e){
            System.out.println("Something wrong with connection");
        }
    }
}
