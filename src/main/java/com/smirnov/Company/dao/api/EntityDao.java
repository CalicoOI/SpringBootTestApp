package com.smirnov.Company.dao.api;

import com.smirnov.Company.model.Employee;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;
import java.util.Optional;

public interface EntityDao<T> {
    List<T> findAll(String queryText, RowMapper<T> rowMapper);
    Integer create(T t, String queryText, SqlParameterSource sqlParameterSource);
    Integer update(T t, String queryText, SqlParameterSource sqlParameterSource);
    Integer delete(String queryText, SqlParameterSource sqlParameterSource);
    Optional<T> getById(String queryText, SqlParameterSource sqlParameterSource, RowMapper<T> rowMapper);
}
