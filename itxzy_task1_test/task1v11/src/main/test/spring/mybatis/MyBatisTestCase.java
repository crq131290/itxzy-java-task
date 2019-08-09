package spring.mybatis;

import com.crq.bean.User;
import com.crq.spring.mytatis.Dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring/mybatis/spring-ac.xml")
public class MyBatisTestCase {
    @Autowired
    @Qualifier("userDao")
    private UserDao ud;
    @Test
    public void test2(){
        System.out.println(ud.getUserById(1));
    }

    @Test
    public void test3(){
        User u = new User();
        u.setAge("11");
        u.setQq("1231231");
        u.setName("王花花");
        SimpleDateFormat start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(start.format(new Date()));
        for(int x=0;x<100;x++){
            ud.addUser(u);
        }
        SimpleDateFormat end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(end.format(new Date()));

    }
}
