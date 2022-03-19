package overwatchutility.business;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import overwatchutility.model.AntiCharaInfo;
import overwatchutility.repository.DbAcsess;

@RequiredArgsConstructor
@Service
public class UpdateAntiCharaInfo {

    private final DbAcsess dbAcsess;
    private final SearchAntiChara searchAntiChara;

    public AntiCharaInfo update(AntiCharaInfo antiCharaInfo) {

        dbAcsess.executUpdate(antiCharaInfo.getCharaName(), antiCharaInfo.getAntiCharaName());
        antiCharaInfo = searchAntiChara.search(antiCharaInfo.getCharaName());

        return antiCharaInfo;
    }
}
