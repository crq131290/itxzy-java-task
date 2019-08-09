package com.crq.junittest;

import org.junit.*;

public class CacluatorTest {
    Cacluator cacluator = null;

    @Before
//    每个测试方法运行时都会调用
    public void testBeforeClass(){
        cacluator = new Cacluator();
        System.out.println("Before");
    }
    @Test
    public void testSum(){
        int rs = cacluator.sum(1,2);
        Assert.assertEquals(rs,3);
    }

    @Ignore
    public void testSub(){
        int rs = cacluator.sub(2,1);
        Assert.assertEquals(rs,1);
    }
    @After
//    每次测试test方法之后执行
    public void testAfter(){
        System.out.println("After");
    }

    @BeforeClass
    public static void myTestBeforeClass1(){
        System.out.println("BeforeClass1");
    }
    @BeforeClass
    public static void myTestBeforeClass2(){
        System.out.println("BeforeClass2");
    }


    @AfterClass
//    所有方法执行之后才会执行
    public static void myTestAfterClass(){
        System.out.println("AfterClass");
    }
}
