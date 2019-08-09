package com.crq.junittest;

public class NJTest {
    public static void main(String[] args){
        Cacluator cacluator = new Cacluator();
        //测试sum方法
        int rs = cacluator.sum(1,2);
        if(rs==3)
            System.out.println("sum()方法正确");
        else
            System.out.println("sum()方法错误");
    }
}
/*
* 不用 Junit 只能写在 main（）方法中，通过运行结果来判断测试结果是否正确。
* 这里需要测试的只有一个个方法，如果有很多方法，那么测试代码就会变得很混乱。*/