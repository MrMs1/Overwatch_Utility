package overwatchutility.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import overwatchutility.business.AddAntiChara;
import overwatchutility.business.AntiCharaSearch;
import overwatchutility.model.AddCharaInfo;
import overwatchutility.model.AntiCharaInfo;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/anticharainfo")
public class Controller {

    private final AntiCharaSearch antiCharaSearch;
    private final AddAntiChara addAntiChara;

    @GetMapping("/charaname/{targetCharaName}")
    public AntiCharaInfo searchAntiChara(@PathVariable String targetCharaName) {

        log.info("Target chara name is : {}", targetCharaName);
        return antiCharaSearch.search(targetCharaName);

    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public AntiCharaInfo createAntiCharaInfo(@RequestBody AddCharaInfo info) {
        return addAntiChara.add(info);
    }

    @PutMapping("/edit")
    public void updateAntiCharaInfo() {

    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAntiCharaInfo() {

    }
}
