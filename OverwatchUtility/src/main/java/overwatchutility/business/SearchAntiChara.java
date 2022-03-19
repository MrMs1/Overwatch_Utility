package overwatchutility.business;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import overwatchutility.model.AntiCharaInfo;
import overwatchutility.repository.DbAcsess;

@RequiredArgsConstructor
@Service
public class SearchAntiChara {

    private final AntiCharaInfo antiCharaInfo;
    private final DbAcsess dbAcsess;

    public AntiCharaInfo search(String targetCharaName) {

        antiCharaInfo.setCharaName(targetCharaName);

        final List<String> recordList = dbAcsess.executeSelect(targetCharaName);

        if (recordList.isEmpty()) {

            antiCharaInfo.setAntiCharaName("");

        } else {

            antiCharaInfo.setAntiCharaName(recordList.get(0));

        }

        return antiCharaInfo;
    }
}