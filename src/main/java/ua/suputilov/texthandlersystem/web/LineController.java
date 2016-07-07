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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.suputilov.texthandlersystem.dao.LineDao;
import ua.suputilov.texthandlersystem.model.Line;

/**
 *
 * @author sergey_putilov
 */
@RestController
public class LineController {

    @Autowired
    LineDao lineDao;

    @RequestMapping(
            value = "/lines/{fileId}",
            method = RequestMethod.GET,
            headers = "Accept=application/json")
    public ResponseEntity<Iterable<Line>> getTextFiles(@PathVariable("fileId") Integer fileId) {
        Iterable<Line> lines = lineDao.getTextLinesByFileId(fileId);

        return new ResponseEntity<Iterable<Line>>(lines, HttpStatus.OK);
    }
}
