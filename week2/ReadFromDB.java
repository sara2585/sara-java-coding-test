//Read data from DB
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


// Read data from mySQL:
public class ReadFromDB implements ReadData {
    static final String DB_URL = "jdbc:mysql://localhost:3306/chef";
    static final String USER = "root";
    static final String PASS = "111111";
    // static final String QUERY = "SELECT name, weight FROM vegetable";

    public String[][] readData(String QUERY) {
        //Open a connection
        // DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
        String[][] items = new String[0][2];
        try(
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        // PreparableStatement prepStmt = conn.prepareStatement(QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(QUERY);
        ) { int size = 0;
            // get the size of the resultset;
            if (rs.last()) {
                size = rs.getRow(); 
                rs.beforeFirst();
            }
            // System.out.print(size);
            items = new String[size][2];
            int i = 0;
            while(rs.next()) {
                //Display values
                // System.out.println("name: " + rs.getString("name"));
                items[i][0] = rs.getString("name");
                items[i][1] = rs.getString("weight");

                // System.out.println("weight: " + rs.getString("weight"));
                i += 1;
                // System.out.print(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return(items);
    }

    public static void main(String[] args) {
        String QUERY_veg = "SELECT name, weight FROM vegetable";
        String QUERY_fla = "SELECT name, weight FROM flavor";
        ReadFromDB readdb = new ReadFromDB();
        String[][] vegetables = readdb.readData(QUERY_veg);
        String[][] flavors = readdb.readData(QUERY_fla);
        System.out.println(vegetables);
        System.out.println(flavors);
    }
}
