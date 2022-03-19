package overwatchutility.repository;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class DbAcsess {

    private final NamedParameterJdbcTemplate jdbc;

    public List<String> executeSelect(String charaName) {

        final String sql = "SELECT anti_chara_name FROM AntiCharaTable WHERE chara_name=:chara_name";

        final SqlParameterSource param = new MapSqlParameterSource("chara_name", charaName);

        return jdbc.queryForList(sql, param, String.class);
    }

    public int executUpdate(String charaName, String antiCharaName) {

        final String sql = "UPDATE AntiCharaTable SET anti_chara_name=:anti_chara_name WHERE chara_name=:chara_name";

        final SqlParameterSource param = new MapSqlParameterSource()
                .addValue("chara_name", charaName)
                .addValue("anti_chara_name", antiCharaName);

        return jdbc.update(sql, param);
    }
}
