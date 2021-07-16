/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Connection;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author ACER
 */
public class DBConnection {
    private Connection connection;
    public Connection getConnection() {
        try {
            OracleDataSource oracleDataSource = new OracleDataSource();
            oracleDataSource.setDriverType("thin");
            oracleDataSource.setPassword("mcc53");
            oracleDataSource.setPortNumber(1521);
            oracleDataSource.setServerName("localhost");
            oracleDataSource.setServiceName("XE");
            oracleDataSource.setUser("system");
            this.connection = oracleDataSource.getConnection();
            this.connection.createStatement().execute("alter session set current_schema = HR");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return connection;
        }
    }
}