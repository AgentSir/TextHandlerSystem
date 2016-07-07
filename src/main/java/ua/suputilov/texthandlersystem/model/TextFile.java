/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.suputilov.texthandlersystem.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 *
 * @author sergey_putilov
 */
@Entity
@Table(name = "file_statement")
public class TextFile extends TextBaseObject {

    private Integer fileId;
    private String name;
    private String path;
    private List<Line> lines;

    @Override
    public int hashCode() {
        int hash;

        if (getFileId() != null && getFileId() > 0) {
            hash = new HashCodeBuilder(11, 37).append(getFileId()).toHashCode();
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
        } else if (object instanceof TextFile) {
            final TextFile input = (TextFile) object;
            result = new EqualsBuilder().append(this.getFileId(), input.getFileId()).isEquals();
        } else {
            result = false;
        }

        return result;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "file_statement_id")
    public Integer getFileId() {

        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    @Column(name = "file_name", nullable = false)
    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "file_folder")
    public String getPath() {

        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = {javax.persistence.CascadeType.ALL})
    @JoinColumn(name = "file_statement_id", nullable = false)
    @JsonManagedReference
    public List<Line> getLines() {

        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }
}
