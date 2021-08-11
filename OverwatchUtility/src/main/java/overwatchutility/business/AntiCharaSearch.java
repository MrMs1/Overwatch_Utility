package overwatchutility.business;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import overwatchutility.model.AntiCharaInfo;
import overwatchutility.repository.DbAcsess;

@RequiredArgsConstructor
@Service
public class AntiCharaSearch {

    private final AntiCharaInfo antiCharactorInfo;
    private final DbAcsess dbAcsess;

    public AntiCharaInfo search(String targetCharaName) {

        antiCharactorInfo.setCharaName(targetCharaName);

        final String sql = "SELECT anti_chara_name FROM AntiCharaTable WHERE chara_name=:chara_name";

        final SqlParameterSource param = new MapSqlParameterSource("chara_name", targetCharaName);

        final List<String> recordList = dbAcsess.executeSelect(sql, param);

        if (recordList.isEmpty()) {

            antiCharactorInfo.setAntiCharaName("");

        } else {

            antiCharactorInfo.setAntiCharaName(recordList.get(0));

        }

        return antiCharactorInfo;
    }
}