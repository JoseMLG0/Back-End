package com.josegonzalez.PruebaCoppel.infrastructure.procedurals;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.Map;

@Service
public class EmployeeProcedurals {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeProcedurals(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Transactional
    public boolean validateEmployeeNumber(String number){
        String procedureCall = "{CALL validarNumeroEmpleado(?, ?)}";

        Integer resultValue = jdbcTemplate.execute((ConnectionCallback<Integer>) con -> {
            CallableStatement callableStatement = con.prepareCall(procedureCall);
            callableStatement.setString(1, number);
            callableStatement.registerOutParameter(2, Types.INTEGER);
            callableStatement.execute();
            return callableStatement.getInt(2);
        });

        return resultValue != null && resultValue > 0;
    }
}
