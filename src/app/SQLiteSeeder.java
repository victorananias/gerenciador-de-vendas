package app;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class SQLiteSeeder {

    public static void run() {
        Connection con = Config.getConnection();

        String sql = "INSERT INTO `usuarios` VALUES("
            + "null, 'admin','Administrator','F5BB0C8DE146C67B44BABBF4E6584CC0','não possui','A'"
        +")";
        
        try {
            Statement stmt = con.createStatement();
            stmt.execute(sql);
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}