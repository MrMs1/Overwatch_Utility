package overwatchutility.model;

import org.springframework.stereotype.Component;

import lombok.Data;

/*
 * アンチキャラ名返却用モデルクラス
 */
@Component
@Data
public class AntiCharaInfo {

    private String charaName;
    private String antiCharaName;

}
