package app;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class SQLiteMigrations {
    Connection connection;
    Statement stmt;

    public static void execute() {
        System.out.println("aq");

        SQLiteMigrations migrations =  new SQLiteMigrations();

        migrations.connection = Config.getConnection();

        migrations.createUsuarios();
        migrations.createProdutos();
        migrations.createVendas();
        migrations.createItensVendas();

        System.out.println("Migrations - DONE");

        try {
            migrations.connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void createUsuarios() {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios ("
            + "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
            + "login VARCHAR(100) NOT NULL UNIQUE, "
            + "nome VARCHAR(250) NOT NULL, "
            + "senha VARCHAR(40) DEFAULT NULL, "
            + "cpf VARCHAR(14) DEFAULT NULL, "
            + "tipo CHAR(1) NOT NULL "
        +")";

        try {
            this.stmt = this.connection.createStatement();
            this.stmt.execute(sql);
            System.out.println("table usuarios created");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void createProdutos() {
        String sql = "CREATE TABLE IF NOT EXISTS produtos (" 
            + "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
            + "nome VARCHAR(100) NOT NULL," 
            + "tipo CHAR(1) DEFAULT NULL," 
            + "quantidade INTEGER NOT NULL,"
            + "valor DECIMAL(10, 2) DEFAULT NULL "
        + ")";

        try {
            this.stmt = this.connection.createStatement();
            this.stmt.execute(sql);

        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }

    }

    public void createVendas() {
        String sql = "CREATE TABLE IF NOT EXISTS vendas ("
            + "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
            + "quantidade_total INTEGER NOT NULL,"
            + "valor_total DECIMAL(10,2) NOT NULL,"
            + "created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,"
            + "usuario_id INTEGER NOT NULL, "
            + "FOREIGN KEY (usuario_id) REFERENCES usuarios(id)"
        + ")";

        try {
            this.stmt = this.connection.createStatement();
            this.stmt.execute(sql);

        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public void createItensVendas() {
        String sql = "CREATE TABLE IF NOT EXISTS itens_venda ("
            + "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
            + "venda_id INTEGER NOT NULL,"
            + "produto_id INTEGER NOT NULL,"
            + "valor double DEFAULT NULL,"
            + "quantidade INTEGER DEFAULT NULL, "
            + "FOREIGN KEY (produto_id) REFERENCES produtos(id),"
            + "FOREIGN KEY (venda_id) REFERENCES vendas(id) ON DELETE CASCADE"
        + ")";

        try {
            this.stmt = this.connection.createStatement();
            this.stmt.execute(sql);

        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }
}