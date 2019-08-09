package com.crq.junittest;

import junit.framework.Assert;
import org.junit.Test;
/**
 * 使用 Junit 不需要创建 main() 方法，而且每个测试方法一一对应
 * */
public class JTest {
    @Test
    //测试sum方法
    public void sum2(){
        Cacluator cacluator = new Cacluator();
        int rs = cacluator.sum(1,2);
        Assert.assertEquals(rs,3);
        /**
         *
         * Assert.assertEquals(rs,1);
         * if(result == 3){
         *       System.out.println("add()方法正确");
         *    }
         * */
    }

}
