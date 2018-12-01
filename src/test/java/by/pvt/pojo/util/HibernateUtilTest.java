package by.pvt.pojo.util;

import org.hibernate.Session;
import org.junit.Test;

import static org.junit.Assert.*;

public class HibernateUtilTest {

    @Test
    public void getInstance() {
        assertNotNull(HibernateUtil.getInstance());
    }

    @Test
    public void getSession() {
        Session session = HibernateUtil.getInstance().getSession();

        assertNotNull(session);

        assertEquals(session, HibernateUtil.getInstance().getSession());
    }
}