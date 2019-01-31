
package app;

import java.io.File;
import views.Login;

public class App {
	
    public static void main(String[] args) throws Exception {
        if (!(new File(Config.DBNAME).exists())) {
            SQLiteMigrations.execute();
            SQLiteSeeder.run();
        }
        
        new Login().setVisible(true);
    }
}
