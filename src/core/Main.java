
package core;

import java.sql.SQLException;

import views.Login;

public class Main {
	
    public static void main(String args[]) {
//    	Database db = new Database(new MySqlConnection().getConnection());
//    	
//    	try {
//        	
//			db.select("produtos");
//			
//			while(db.next()) {
//				System.out.println(db.getResult().getString("nome"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e);
//            System.out.println(db.error);
//		}
    	
        new Login().setVisible(true);
    }
}
