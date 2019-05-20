package Service;

import mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Student;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceStudent {//service 调用这里会去执行mapper中的sql语句对数据库操作
    @Autowired
    private StudentMapper studentMapper;

    public String add(Student student){//c

        this.studentMapper.add(student);
        System.out.println(student);
        return student.getName();
    }

    public Student update(Student student) throws Exception {//u
        this.studentMapper.update(student);
        return student;
    }

    public Student get(int id) throws Exception {//r
        return  this.studentMapper.get(id);
    }

    public String delete(int id) throws Exception {//d
        this.studentMapper.delete(id);
        String msg = "删除成功";
        return msg;
    }

    public List<Student> list(){
        List<Student> list  = this.studentMapper.list();
        return list;
    }

    public void insertList(List<Student> list){
        this.studentMapper.insertList(list);
    }


}
