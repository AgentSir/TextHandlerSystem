/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.suputilov.texthandlersystem.dao;

import java.util.List;
import ua.suputilov.texthandlersystem.model.Line;

/**
 *
 * @author sergey_putilov
 */
public interface LineDao {

    public List<Line> getTextLinesByFileId(Integer fileId);
}
