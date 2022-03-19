package overwatchutility.business;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import overwatchutility.model.AntiCharaInfo;
import overwatchutility.repository.DbAcsess;

@RequiredArgsConstructor
@Service
public class AddAntiChara {

    private final DbAcsess dbAcsess;
    private final SearchAntiChara searchAntiChara;

    public AntiCharaInfo add(AntiCharaInfo info) {

        AntiCharaInfo antiCharaInfo = searchAntiChara.search(info.getCharaName());

        final List<String> addCharaList = Arrays.asList(info.getAntiCharaName().split("\\s*,\\s*"));
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

        dbAcsess.executUpdate(info.getCharaName(), updatedAntiCharaNames);
        antiCharaInfo = searchAntiChara.search(info.getCharaName());

        return antiCharaInfo;
    }

}
