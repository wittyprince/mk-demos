package com.mk.demos.java.jextend;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;

/**
 * override测试
 * 一大两小两同
 * 1.一大：子类的方法访问权限控制符只能相同或更大
 * 2.两小：抛出异常和返回值只能变小，能够转型为父类对象。
 * 3.两同：方法名和参数列表必须完全相同
 *
 * @author WangChen
 * Created on 2021/2/25 21:09
 * @since 1.0
 */
public class OverrideTest {


}

class Father{
    protected Number m(int a, Integer b, Object c) throws SQLException {
        System.out.println("Father m... ");
        return new Integer("7");
    }
}
class Son extends Father{
    @Override
    public Integer m(int a, Integer b, Object c) throws SQLClientInfoException {
        if (a == 0){
            throw new SQLClientInfoException();
        }
        return new Integer(17);
    }
}
