import mapper.StudentMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestStudent {
    private Logger logger = LogManager.getLogger(TestStudent.class);

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private Student student;
    @Before
    public void before(){
        logger.info("test开始");
    }
    @After
    public void after(){
        logger.info("test结束");
    }

    @Test
public void add(){
    student.setName("dante");
    studentMapper.add(student);
}

    @Test
    public void get(){
        try {
            studentMapper.get(1);
            logger.info("try");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("catch");
        }finally {
            logger.info("finally");
        }
    }
}
