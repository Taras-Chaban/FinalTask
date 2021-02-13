package com.finalTask.tsk.entity;

import java.sql.ResultSet;

public interface EntityMap <E> {
    E mapRow(ResultSet resultSet);
}
