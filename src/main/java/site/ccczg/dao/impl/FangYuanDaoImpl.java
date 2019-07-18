package site.ccczg.dao.impl;

import com.mysql.jdbc.Connection;
import site.ccczg.dao.FangYuanDao;
import site.ccczg.domain.FangYuanCar;
import site.ccczg.utils.JDBCUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: Effort
 * @Date: 2019/7/18 14:20
 * @Description: FangYuanDao实现
 */
public class FangYuanDaoImpl implements FangYuanDao {
    /**
     * @Author 陈治国
     * @Description 添加车辆
     * @Date 2019/7/18 17:19
     * @Param [fangYuancar]
     * @return void
     **/
    @Override
    public void add(FangYuanCar fangYuancar) {

        String sql = "INSERT INTO fangyuancar VALUES(NULL,?,?,?,?,?,?)";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, fangYuancar.getMassage());
            statement.setString(2, fangYuancar.getCardsdate() );
            statement.setString(3,fangYuancar.getMileage());
            statement.setString(4,fangYuancar.getFactorydate());
            statement.setString(5, fangYuancar.getNewcarprices());
            statement.setString(6, fangYuancar.getFixedprice());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

