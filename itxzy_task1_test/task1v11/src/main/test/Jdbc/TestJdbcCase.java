package Jdbc;

import com.crq.Jdbc.Dao.UserDao;
import com.crq.Jdbc.Dao.UserDaoImpl;
import org.junit.Test;

public class TestJdbcCase {
    @Test
    public void test1(){
        UserDao ud = new UserDaoImpl();
        System.out.println(ud.getUserById(1));
    }
}
