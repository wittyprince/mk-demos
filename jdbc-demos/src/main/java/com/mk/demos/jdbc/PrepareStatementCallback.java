package com.mk.demos.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * PrepareStatementCallback
 *
 * @author WangChen
 * Created on 2021/1/21 19:45
 * @since 1.0
 */
public interface PrepareStatementCallback {

    Object doInPreparedStatement(PreparedStatement ps) throws SQLException;
}
