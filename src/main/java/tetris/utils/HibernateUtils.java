package tetris.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import tetris.dbmodels.User;

import java.util.Properties;

public class HibernateUtils {
//  private static final String REMOTE_CONNECTION_URL = System.getenv("REMOTE_CONNECTION_URL");
//  private static final String REMOTE_CONNECTION_PASSWORD = System.getenv("REMOTE_CONNECTION_PASSWORD");
//  private static final String REMOTE_CONNECTION_USERNAME = System.getenv("REMOTE_CONNECTION_USERNAME");

  private static SessionFactory sessionFactory;

  static {
    try {
      Properties prop = new Properties();
//      if (REMOTE_CONNECTION_URL != null) {
        //      JawsDB Clod MySQL Database
//        prop.setProperty("hibernate.connection.url", REMOTE_CONNECTION_URL);
//        prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
//        prop.setProperty("hibernate.connection.password", REMOTE_CONNECTION_PASSWORD);
//        prop.setProperty("hibernate.connection.username", REMOTE_CONNECTION_USERNAME);
//        prop.setProperty("hibernate.default_schema", "ycm07x7z21h40k84");
//        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
//        prop.setProperty("hibernate.connection.CharSet", "utf8");
//        prop.setProperty("hibernate.connection.characterEncoding", "utf8");
//        prop.setProperty("hibernate.connection.useUnicode", "true");
//      } else {
        //      Local MySQL Server
        prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/tetris");
        prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        prop.setProperty("hibernate.connection.password", "root");
        prop.setProperty("hibernate.connection.username", "root");
        prop.setProperty("hibernate.default_schema", "tetris");
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        prop.setProperty("hibernate.connection.CharSet", "utf8");
        prop.setProperty("hibernate.connection.characterEncoding", "utf8");
        prop.setProperty("hibernate.connection.useUnicode", "true");
//      }

      sessionFactory = new Configuration()
              .addPackage("tetris")
              .addProperties(prop)
              .addAnnotatedClass(User.class)
              .buildSessionFactory();
    } catch (Exception ex) {
      System.out.println("----------------------");
      System.out.println(ex);
    }
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}
