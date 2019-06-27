package pojo;

public class Student {
    private String name;
    private String qq;
    private int id;
    private int age;

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", qq='" + qq + '\'' + ", id=" + id + ", age=" + age + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
