package overwatchutility.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import overwatchutility.business.AntiCharaSearch;
import overwatchutility.model.AntiCharactorInfo;

@RestController
@RequestMapping("/overwatchutility")
public class Controller {

    private final AntiCharaSearch antiCharaSearch;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public Controller(AntiCharaSearch antiCharaSearch) {
        this.antiCharaSearch = antiCharaSearch;
    }

    @GetMapping("/searchantichara")
    public AntiCharactorInfo searchAntiChara(
            @RequestParam(value = "name", defaultValue = "default") String targetCharaName) {

        logger.info("Target chara name is : {}", targetCharaName);
        return antiCharaSearch.search(targetCharaName);

    }
}
