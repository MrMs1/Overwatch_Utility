package overwatchutility.repository;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class DbAcsess {

    private final NamedParameterJdbcTemplate jdbc;

    public DbAcsess(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<String> executeQuery(String charaName) {

        String sql = "SELECT anti_chara_name FROM AntiCharaTable WHERE chara_name=:chara_name";

        SqlParameterSource param = new MapSqlParameterSource("chara_name", charaName);

        List<String> recordList = jdbc.queryForList(sql, param, String.class);

        return recordList;
    }
}
