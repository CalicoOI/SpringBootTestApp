package com.smirnov.Company.dao.api.implementation;

import com.smirnov.Company.dao.api.EntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class EntityDaoImplementation<T> implements EntityDao<T> {
    @Autowired
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<T> findAll(String queryText, RowMapper<T> rowMapper) {
        return namedParameterJdbcTemplate.query(queryText, rowMapper);
    }

    @Override
    public Integer create(T t, String queryText, SqlParameterSource sqlParameterSource) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(queryText, sqlParameterSource, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey().intValue());
    }

    @Override
    public Integer update(T t, String queryText, SqlParameterSource sqlParameterSource) {
        return namedParameterJdbcTemplate.update(queryText, sqlParameterSource);
    }

    @Override
    public Integer delete(String queryText, SqlParameterSource sqlParameterSource) {
        return namedParameterJdbcTemplate.update(queryText, sqlParameterSource);
    }

    @Override
    public Optional<T> getById(String queryText, SqlParameterSource sqlParameterSource, RowMapper<T> rowMapper) {
        List<T> results = namedParameterJdbcTemplate.query(queryText, sqlParameterSource, rowMapper);
        return Optional.ofNullable(DataAccessUtils.uniqueResult(results));
    }
}
