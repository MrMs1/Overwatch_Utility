package overwatchutility.business;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import overwatchutility.model.AntiCharaInfo;
import overwatchutility.repository.DbAcsess;

@RequiredArgsConstructor
@Service
public class DeleteAntiCharaInfo {

    private final DbAcsess dbAcsess;
    private final SearchAntiChara searchAntiChara;

    public void delete(AntiCharaInfo info) {

        AntiCharaInfo antiCharaInfo = searchAntiChara.search(info.getCharaName());

        final List<String> deleteCharaList = Arrays.asList(info.getAntiCharaName().split("\\s*,\\s*"));
        final List<String> antiCharaList = Arrays.asList(antiCharaInfo.getAntiCharaName().split("\\s*,\\s*"));

        deleteCharaList.forEach(s -> antiCharaList.remove(s));

        dbAcsess.executeSelect(String.join(",", antiCharaList));

    }
}
