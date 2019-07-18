package site.ccczg.utils;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @Author: Effort
 * @Date: 2019/7/18 14:12
 * @Description: JDBC工具类
 */
public class JDBCUtil {

    private static String url;
    private static String username;
    private static String password;

    static {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
            String driver = bundle.getString("driver");
            url = bundle.getString("url");
            username = bundle.getString("username");
            password = bundle.getString("password");
            Class.forName(driver);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * @return Connection
     *
     */
    public static Connection getConnection() throws SQLException {
        return (Connection) DriverManager.getConnection(url, username, password);
    }
}

