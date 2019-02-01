
package app;

import models.Produto;
import views.CadastroProduto;
import views.EdicaoProduto;
import views.Login;

public class App {
	
    public static void main(String[] args) throws Exception {
        //new EdicaoProduto(Produto.find(1)).setVisible(true);
         new CadastroProduto().setVisible(true);
        // if (!(new File(Config.DBNAME).exists()) && Config.DRIVER_CLASS == "org.sqlite.JDBC") {
        //     SQLiteMigrations.execute();
        //     SQLiteSeeder.run();
        // }
        
        // new Login().setVisible(true);
    }
}
