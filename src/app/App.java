
package app;

import java.sql.Connection;
import views.Login;

public class App {
	
    public static void main(String[] args) throws Exception {
        // Connection con = new CustomConnection().getConnection();
        // SQLiteMigrations.execute();
        new Login().setVisible(true);
        // createNewDatabase("vendas.db");
        // System.out.println("hello");
    }
}
