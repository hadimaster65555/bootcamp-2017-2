/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimas.maryanto.universitas.konfig;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author dimmaryanto93
 */
public class KonfigDB {

    private final static String url = "jdbc:postgresql://localhost:5432/bootcamp_2";
    private final static String username = "bootcamp_2";
    private final static String password = "bootcamp";

    public static DataSource getDatasource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }
}
