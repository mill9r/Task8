import java.sql.*;

/**
 * Created by Administrator on 12/29/2016.
 */
public class SQLQuery {

    public static double dbUpdate(String string) {
        double price = 0;
        Connection con = JDBCConnetion.getConnection();
        try {


            String query = "SELECT price,cash from student.cash WHERE cash =" + "'" + string + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                price = rs.getDouble("price");
                System.out.println("DB works");
                System.out.println(rs.getDouble("price"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price;
    }
}
