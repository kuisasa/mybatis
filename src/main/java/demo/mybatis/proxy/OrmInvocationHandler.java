package demo.mybatis.proxy;

import demo.mybatis.annoation.OrmInsert;
import demo.mybatis.annoation.OrmSelect;
import demo.mybatis.hander.AnnoationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class OrmInvocationHandler implements InvocationHandler {

    private Object targetObject;

    public OrmInvocationHandler(Object targetObject){
        this.targetObject = targetObject;
    }

    /**
     * 执行具体的拦截逻辑处理
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //判断是否有插入注解
        boolean insertFalg = method.isAnnotationPresent(OrmInsert.class);
        if (insertFalg){
            OrmInsert ormInsert = method.getDeclaredAnnotation(OrmInsert.class);
            if (ormInsert!=null){
                return AnnoationHandler.handleOrmInsert(ormInsert,method,args);
            }
        }

        //判断是否有查询注解
        boolean selectFalg = method.isAnnotationPresent(OrmSelect.class);
        if (selectFalg){
            OrmSelect ormSelect = method.getDeclaredAnnotation(OrmSelect.class);
            if (ormSelect!=null){
                return AnnoationHandler.handleOrmSelect(ormSelect,proxy,method,args);
            }
        }
        return null;
    }
}
