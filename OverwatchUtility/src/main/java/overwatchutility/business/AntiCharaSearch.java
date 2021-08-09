package overwatchutility.business;

import java.util.List;

import org.springframework.stereotype.Service;

import overwatchutility.model.AntiCharactorInfo;
import overwatchutility.repository.DbAcsess;

@Service
public class AntiCharaSearch {

    private final AntiCharactorInfo antiCharactorInfo;
    private final DbAcsess dbAcsess;

    public AntiCharaSearch(AntiCharactorInfo antiCharactorInfo, DbAcsess dbAcsess) {
        this.antiCharactorInfo = antiCharactorInfo;
        this.dbAcsess = dbAcsess;
    }

    public AntiCharactorInfo search(String targetCharaName) {
        List<String> recordList = dbAcsess.executeQuery(targetCharaName);
        antiCharactorInfo.setAntiCharaName(recordList.get(0));
        return antiCharactorInfo;
    }
}