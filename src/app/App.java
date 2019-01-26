
package app;

import java.sql.SQLException;

import views.Login;

public class App {
	
    public static void main(String[] args) throws Exception {
//    	Database db = new Database(new MySqlConnection().getConnection());
//    	
//    	try {
//        	
//			db.select("produtos");
//			
//			while(db.next()) {
//				System.out.println(ddb.getResult().getString("nome"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e);
//            System.out.println(db.error);
//		}
    	
        new Login().setVisible(true);
    }
}
