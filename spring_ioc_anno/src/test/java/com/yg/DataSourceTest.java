package com.yg;

import com.alibaba.druid.filter.AutoLoad;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.ibatis.SqlMapSessionWrapper;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.cj.jdbc.Driver;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/4 19:36
 */
public class DataSourceTest {




    /**
     * c3p0
     *
     * @throws PropertyVetoException
     * @throws SQLException
     */
    @Test
    public void test1() throws PropertyVetoException, SQLException {

        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDataSourceName("comboPooledDataSource");
        comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mysql?serverTimezone=Asia/Shanghai");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("root");
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println("connection = " + connection);
        connection.close();
    }


    /**
     * druid 数据源
     *
     * @throws PropertyVetoException
     * @throws SQLException
     */
    @Test
    public void test2() throws PropertyVetoException, SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriver(new Driver());
//        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/mysql?serverTimezone=Asia/Shanghai");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        Connection connection = druidDataSource.getConnection();
        System.out.println("connection = " + connection);
        connection.close();
    }


    /**
     * c3p0 配置文件
     *
     * @throws PropertyVetoException
     * @throws SQLException
     */
    @Test
    public void test3() throws PropertyVetoException, SQLException {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        resourceBundle.getString("jdbc.driver");
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDataSourceName("comboPooledDataSource");
        comboPooledDataSource.setDriverClass(resourceBundle.getString("jdbc.driver"));
        comboPooledDataSource.setJdbcUrl(resourceBundle.getString("jdbc.url"));
        comboPooledDataSource.setUser(resourceBundle.getString("jdbc.username"));
        comboPooledDataSource.setPassword(resourceBundle.getString("jdbc.password"));
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println("connection = " + connection);
        connection.close();
    }


    /**
     * spring 容器 获取数据源对象
     *
     * @throws PropertyVetoException
     * @throws SQLException
     */
    @Test
    public void test4() throws PropertyVetoException, SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource bean = applicationContext.getBean(javax.sql.DataSource.class);
        Connection connection = bean.getConnection();
        System.out.println("connection = " + connection.getSchema());
        connection.close();
    }

}
