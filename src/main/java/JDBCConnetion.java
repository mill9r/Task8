import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnetion {
    public static Connection getConnection() {
        Properties props = new Properties();
        FileInputStream fis = null;
        Connection con = null;

//            File f=new File("../resources/config.connection.properties");
        try {
            fis = new FileInputStream("C:\\Users\\Administrator\\IdeaProjects\\Task8\\src\\main\\resources\\connection.properties");

//            System.out.println(new File(".").getCanonicalPath());
//            fis = new FileInputStream("../../resources/connection.connection.properties");


            props.load(fis);


            // load the Driver Class

            Class.forName(props.getProperty("DB_DRIVER_CLASS"));


            // create the connection now

            con = DriverManager.getConnection(props.getProperty("DB_URL"),
                    props.getProperty("DB_USERNAME"),
                    props.getProperty("DB_PASSWORD"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return con;
    }
}