/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.suputilov.texthandlersystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.suputilov.texthandlersystem.dao.TextFileDao;
import ua.suputilov.texthandlersystem.model.Text;
import ua.suputilov.texthandlersystem.model.TextFile;
import ua.suputilov.texthandlersystem.utils.TextHandler;

/**
 *
 * @author sergey_putilov
 */
@RestController
public class TextFileController {

    @Autowired
    TextFileDao textFileDao;

    @Autowired
    TextHandler textHandler;

    @RequestMapping(
            value = "/files",
            method = RequestMethod.GET,
            headers = "Accept=application/json")
    public ResponseEntity<Iterable<TextFile>> getTextFiles() {
        Iterable<TextFile> textFiles = textFileDao.getAllTextFiles();

        return new ResponseEntity<Iterable<TextFile>>(textFiles, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/text/processText",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<TextFile> createTextFileStatistic(@RequestBody Text text) {
        TextFile textFile = textHandler.processText(text);

        return new ResponseEntity<TextFile>(textFile, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/search/files/{minCountLines}",
            method = RequestMethod.GET,
            headers = "Accept=application/json")
    public ResponseEntity<Iterable<TextFile>> getTextFilesByCriteria(@PathVariable("minCountLines") Integer minCountLines) {
        Iterable<TextFile> textFiles = textFileDao.getTextFilesByMinCountLineCriteria(minCountLines);

        return new ResponseEntity<Iterable<TextFile>>(textFiles, HttpStatus.OK);
    }
}
