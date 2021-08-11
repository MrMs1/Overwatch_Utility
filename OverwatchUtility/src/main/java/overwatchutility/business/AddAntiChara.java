package overwatchutility.business;

import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import overwatchutility.model.AddCharaInfo;
import overwatchutility.model.AntiCharaInfo;
import overwatchutility.repository.DbAcsess;

@RequiredArgsConstructor
@Service
public class AddAntiChara {

    private final DbAcsess dbAcsess;
    private final AntiCharaSearch antiCharaSearch;

    public AntiCharaInfo add(AddCharaInfo info) {

        AntiCharaInfo antiCharaInfo = antiCharaSearch.search(info.getTargetCharaName());

        final List<String> addCharaList = Arrays.asList(info.getAddCharaName().split("\\s*,\\s*"));
        String currentAntiCharaNames = antiCharaInfo.getAntiCharaName();
        String updatedAntiCharaNames = null;

        for (String addChara : addCharaList) {

            if (currentAntiCharaNames.contains(addChara)) {
                continue;
            }

            updatedAntiCharaNames = String.join(",", currentAntiCharaNames, addChara);

        }

        if (updatedAntiCharaNames == null) {
            return antiCharaInfo;
        }

        final String sql = "UPDATE AntiCharaTable SET anti_chara_name=:anti_chara_name WHERE chara_name=:chara_name";

        final SqlParameterSource param = new MapSqlParameterSource()
                .addValue("anti_chara_name", updatedAntiCharaNames)
                .addValue("chara_name", info.getTargetCharaName());

        dbAcsess.executUpdate(sql, param);
        antiCharaInfo = antiCharaSearch.search(info.getTargetCharaName());

        return antiCharaInfo;
    }

}
