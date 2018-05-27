package tetris.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import tetris.dbmodels.User;

public class HibernateUtils {
  private static SessionFactory sessionFactory;

  static {
    try {
      Configuration configuration = new Configuration().configure();

      configuration.addAnnotatedClass(User.class);

      StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
              .applySettings(
                      configuration.getProperties())
              .build();

      sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    } catch (Exception ex) {
      System.out.println("----------------------");
      System.out.println(ex);
    }
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}
