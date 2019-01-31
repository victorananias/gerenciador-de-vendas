
package app;

import java.io.File;

import models.Produto;
import views.CadastroProduto;
import views.EdicaoProduto;
import views.Login;

public class App {
	
    public static void main(String[] args) throws Exception {
        new CadastroProduto().setVisible(true);
        // if (!(new File(Config.DBNAME).exists()) && Config.DRIVER_CLASS == "org.sqlite.JDBC") {
        //     SQLiteMigrations.execute();
        //     SQLiteSeeder.run();
        // }
        
        // new Login().setVisible(true);
    }
}
