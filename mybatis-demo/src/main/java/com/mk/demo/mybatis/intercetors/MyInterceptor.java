package com.mk.demo.mybatis.intercetors;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.Statement;
import java.util.Properties;

/**
 * MyInterceptor
 *
 * @author WangChen
 * Created on 2025/1/7
 * @since 1.0
 */
@Intercepts({
        @Signature(
                type = Executor.class,
                method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
        )

})
public class MyInterceptor implements Interceptor {

    static int MAPPED_STATEMENT_INDEX = 0;// 这是对应上面的args的序号
    static int PARAMETER_INDEX = 1;
    static int ROWBOUNDS_INDEX = 2;
    static int RESULT_HANDLER_INDEX = 3;

    /**
     * 起拦截作用,在此定义一些功能
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
//        Object target = invocation.getTarget();
//        MetaObject metaObject = SystemMetaObject.forObject(target);
//        Object value = metaObject.getValue("parameterHandler.parameterObject");
//        System.out.println("拦截到的原参数为:" + value);
//        metaObject.setValue("parameterHandler.parameterObject",4);
//        System.out.println("修改后的参数为:" + metaObject.getValue("parameterHandler.parameterObject"));



        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) args[MAPPED_STATEMENT_INDEX];
        Object parameter = args[PARAMETER_INDEX];
        RowBounds rowBounds = (RowBounds) args[2];
        ResultHandler resultHandler = (ResultHandler) args[3];

        Executor executor = (Executor) invocation.getTarget();
        BoundSql boundSql;
        //由于逻辑关系，只会进入一次
        if (args.length == 4) {
            //4 个参数时
            boundSql = mappedStatement.getBoundSql(parameter);
        } else {
            //6 个参数时
            boundSql = (BoundSql) args[5];
        }

        String sql = boundSql.getSql();// 获取到SQL ，进行调整
        String name = mappedStatement.getId();
        System.out.println("拦截的方法名是:" + name + ",sql是" + sql + ",参数是" + (parameter));
        String execSql = sql; //pruningColumn(enablePruning.get().getReserveColumns(), sql);
        System.out.println("修改后的sql是:" + execSql);

        // 重新new一个查询语句对像
        BoundSql newBoundSql = new BoundSql(mappedStatement.getConfiguration(), execSql, boundSql.getParameterMappings(), boundSql.getParameterObject());
        // 把新的查询放到statement里
//        MappedStatement newMs = copyFromMappedStatement(mappedStatement, new BoundSqlSqlSource(newBoundSql));
//        for (ParameterMapping mapping : boundSql.getParameterMappings()) {
//            String prop = mapping.getProperty();
//            if (boundSql.hasAdditionalParameter(prop)) {
//                newBoundSql.setAdditionalParameter(prop, boundSql.getAdditionalParameter(prop));
//            }
//        }
//        args[MAPPED_STATEMENT_INDEX] = newMs;
        // 因为涉及分页查询PageHelper插件，所以不能设置为null，需要业务上下文执行完成后设置为null
        // 注意：需要配置在分页查询插件pageHelper之后，先拼接sql，再分页
//            enablePruning.set(null);

        //放行方法
        Object proceed = invocation.proceed();
        return proceed;
    }

    @Override
    public Object plugin(Object target) {
        return Interceptor.super.plugin(target);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("自定义属性:name and age -> " + properties.getProperty("name") + " and " + properties.getProperty("age"));
        Interceptor.super.setProperties(properties);
    }
}
