package mybatis;

import com.crq.mybatis.DBUtil;
import com.crq.mybatis.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestMybatisCase {
    @Test
    public void test1(){
        SqlSession session = DBUtil.open();
        UserDao ud = session.getMapper(UserDao.class);
        System.out.println(ud.getUserById(1));
    }

}
