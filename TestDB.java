import java.sql.Connection;
import util.DBConnection;

public class TestDB {
    public static void main(String[] args) {

        Connection con = DBConnection.getConnection();

        if (con != null) {
            System.out.println(" Connected to MySQL Database!");
        } else {
            System.out.println(" Connection Failed!");
        }
    }
}