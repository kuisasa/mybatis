package demo.mybatis.util;

import java.sql.Connection;

public class JDBCUtil {
    private static String connect;
    private static String driverClassName;
    private static String URL;
    private static String username;
    private static String password;
    private static boolean autoCommit;

    /** 声明一个 Connection类型的静态属性，用来缓存一个已经存在的连接对象 */
    private static Connection conn;

    static {
        config();
    }

    /**
     * 开头配置自己的数据库信息
     */
    private static void config() {
        /*
         * 获取驱动
         */
        driverClassName = "com.mysql.jdbc.Driver";
        /*
         * 获取URL
         */
        URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
        /*
         * 获取用户名
         */
        username = "root";
        /*
         * 获取密码
         */
        password = "root";
        /*
         * 设置是否自动提交，一般为false不用改
         */
        autoCommit = false;

    }
    static void load() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");



    }
}
