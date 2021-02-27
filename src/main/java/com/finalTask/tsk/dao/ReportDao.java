package com.finalTask.tsk.dao;

import com.finalTask.tsk.DB.PoolConnectionBuilder;
import com.finalTask.tsk.entity.EntityMap;
import com.finalTask.tsk.entity.Report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReportDao {
    private static final String SQL_GET_REPORTS = "SELECT * FROM project.reports";

    public ArrayList<Report> getReports() {
        ArrayList<Report> reports = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {
            connection = PoolConnectionBuilder.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_GET_REPORTS);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                reports.add(new ReportMapper().mapRow(resultSet));
            }

        } catch (SQLException e) {
            PoolConnectionBuilder.getInstance().rollbackAndClose(connection);
            e.printStackTrace();
        } finally {
            PoolConnectionBuilder.getInstance().commitAndClose(connection);
        }
        return reports;
    }

    private static class ReportMapper implements EntityMap<Report> {

        @Override
        public Report mapRow(ResultSet resultSet) {
            Report report = new Report();
            try {
                report.setId(resultSet.getLong("report_id"));
                report.setReportType(resultSet.getString("report_type"));
                report.setDate(resultSet.getTimestamp("report_date"));
                report.setCashBefore(resultSet.getInt("report_cash_before"));
                report.setCashAfter(resultSet.getInt("report_cash_after"));
                report.setCurrentCash(resultSet.getInt("report_cash"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return report;
        }

        @Override
        public void mapField(PreparedStatement preparedStatement, Report entity) {

        }
    }
}
