package spring.jdbc;

import com.crq.spring.jdbc.Dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring/jdbc/ac-jdbc2.xml")
public class JdbcTestCase2 {
    @Resource(name="userDaoImpl")
//    @Autowired
    private UserDao ud;
    @Test
    public void testJdbc(){
        System.out.println(ud.getUserById(1));
    }
}
