package com.finalTask.tsk.entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface EntityMap <E> {
    E mapRow(ResultSet resultSet);

    void mapField(PreparedStatement preparedStatement, E entity) throws SQLException;
}
