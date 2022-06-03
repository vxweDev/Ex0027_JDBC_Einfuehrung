package ex0027;

import java.sql.*;
import java.util.Properties;

public class UI {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    System.out.println("JDBC");
    // 1. Treiber laden
    Class.forName("org.postgresql.Driver");

    // 2. JDBC url
    String url = "jdbc:postgresql://localhost:5432/POS1";


    // 3. create connection object
    Connection connection = DriverManager.getConnection(url, "postgres", "geheim123");

    if(connection.isValid(1000)){
      Statement statement = connection.createStatement();
      statement.execute("DROP TABLE person1");
      statement.execute("CREATE TABLE person1(id INT PRIMARY KEY, nachname VARCHAR(30) NOT NULL, vorname VARCHAR(30));");
      statement.execute("INSERT INTO person1 (id, nachname, vorname) VALUES (1, 'n1', 'n2')");
      statement.execute("INSERT INTO person1 (id, nachname, vorname) VALUES (2, 'vorname2', 'nachname2')");
      statement.close();

    }
    // TCP Verbindung zum Server wird geschlossen
    connection.close();

  }
}