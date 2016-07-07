/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.suputilov.texthandlersystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 *
 * @author sergey_putilov
 */
@Entity
@Table(name = "file_statement_breakdown")
public class Line extends TextBaseObject {

    private Integer lineId;
    private int lineNumber;
    private String text;
    private Integer fileId;

    @Override
    public int hashCode() {
        int hash;

        if (getLineId() != null && getLineId() > 0) {
            hash = new HashCodeBuilder(11, 37).append(getLineId()).toHashCode();
        } else {
            hash = super.hashCode();
        }

        return hash;
    }

    @Override
    public boolean equals(final Object object) {
        boolean result;

        if (null == object) {
            result = false;
        } else if (this == object) {
            result = true;
        } else if (object instanceof Line) {
            final Line input = (Line) object;
            result = new EqualsBuilder().append(this.getLineId(), input.getLineId()).isEquals();
        } else {
            result = false;
        }

        return result;
    }

    @Id
    @GeneratedValue
    @Column(name = "file_statement_breakdown_id")
    public Integer getLineId() {

        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    @Column(name = "text")
    public String getText() {

        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name = "line_number", nullable = false)
    public int getLineNumber() {

        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Column(name = "file_statement_id", nullable = false, insertable = false, updatable = false)
    public Integer getFileId() {

        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }
}
