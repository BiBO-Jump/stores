package com.up.stores;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class StoresApplicationTests {
    //测试数据库是否连通
    @Autowired//自动装配
    private DataSource dataSource;
    @Test
    void contextLoads() {
    }
    //Hikari管理数据库连接对象
    @Test
    void getConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
