package com.mk.demos.java;

/**
 * pojo
 *
 * 测试 Boolean类型的getter/setter方法
 *
 * @author WangChen
 * Created on 2021/2/26 16:08
 * @since 1.0
 */
public class Pojo {

    private Boolean deleted;
    // 注意这里的isMarked字段，在自动生成getter/setter方法时，
    // 结果是getMarked,setMarked，在反序列化是，会把该字段错误解析为marked
    // 所以在POJO中不推荐使用isXXX,而是直接使用XXX，如deleted字段
    private Boolean isMarked;

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getMarked() {
        return isMarked;
    }

    public void setMarked(Boolean marked) {
        isMarked = marked;
    }
}
