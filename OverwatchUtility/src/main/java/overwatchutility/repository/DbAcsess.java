package overwatchutility.repository;

import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class DbAcsess {

    private final NamedParameterJdbcTemplate jdbc;

    public List<String> executeSelect(String sql, SqlParameterSource param) {
        return jdbc.queryForList(sql, param, String.class);
    }

    public int executUpdate(String sql, SqlParameterSource param) {
        return jdbc.update(sql, param);
    }
}
