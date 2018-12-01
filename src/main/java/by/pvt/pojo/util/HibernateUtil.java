package by.pvt.pojo.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private final ThreadLocal<Session> threadLocal = new ThreadLocal<>();
    private SessionFactory sessionFactory;
    private static HibernateUtil hibernateUtil;


    private HibernateUtil(){
        sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
    }

    public static HibernateUtil getInstance(){

        if (hibernateUtil == null){
            hibernateUtil = new HibernateUtil();
        }
        return hibernateUtil;
    }

    public Session getSession(String dataBaseName) {
        return getSession();
    }

    public Session getSession(){

        Session session = threadLocal.get();

        if(session == null){
            session = sessionFactory.openSession();
            threadLocal.set(session);
        }

        return session;
    }

}
