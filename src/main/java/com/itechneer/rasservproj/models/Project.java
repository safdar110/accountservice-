package com.itechneer.rasservproj.models;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "Project")
@SQLDelete(sql = "UPDATE Project SET deleted=true WHERE id=?")
@Where(clause = "deleted=false")
@FilterDef(name = "deletedProjectFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedProjectFilter", condition = "deleted = :isDeleted")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(max = 50)
    private String projname;

    private int projcost;

//    @NotBlank
//    @Size(max = 15)
    @Temporal(TemporalType.DATE)
    private Date startdate;

//    @Size(max = 15)
    @Temporal(TemporalType.DATE)
    private Date enddate;

    private short numresource;

    @Size(max = 355)
    private String detail;

    @Column
    private boolean deleted = Boolean.FALSE;

    public Project() {
    }

    public Project(String projname, int projcost, Date startdate, Date enddate, short numresource, String detail, boolean deleted) {
        this.projname = projname;
        this.projcost = projcost;
        this.startdate = startdate;
        this.enddate = enddate;
        this.numresource = numresource;
        this.detail = detail;
        this.deleted = deleted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProjname() {
        return projname;
    }

    public void setProjname(String projname) {
        this.projname = projname;
    }

    public int getProjcost() {
        return projcost;
    }

    public void setProjcost(int projcost) {
        this.projcost = projcost;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

   public short getNumresource() {
        return numresource;
    }

    public void setNumresource(short numresource) {
        this.numresource = numresource;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projname='" + projname + '\'' +
                ", projcost=" + projcost +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", numresource=" + numresource +
                ", detail='" + detail + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
