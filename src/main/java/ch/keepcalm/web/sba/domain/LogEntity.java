package ch.keepcalm.web.sba.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by hkesq on 01.06.2015.
 */
@Entity
//@Table(name = "T_SPA_LOGS", schema = "TAEADM", catalog = "")
@Table
public class LogEntity {


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = false)
    private Date updated;

    @PrePersist
    protected void onCreate() {
        updated = created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }




    private String spaClientApplikation;
    private String spaClientVersion;

    private Timestamp spaTimestamp;
    @Basic
    @Column(name="SPA_TIMESTAMP", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    public Timestamp getSpaTimestamp() {
        return spaTimestamp;
    }

    public void setSpaTimestamp(Timestamp spaTimestamp) {
        this.spaTimestamp = spaTimestamp;
    }
    private byte[] spaMeldung;
    private String spaCorrelationId;
    private String spaFaultType;
    private String spaFaultCode;
    private byte[] spaDebugInformation;
    private String spaSeverity;


    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Basic
    @Column(name = "SPA_CLIENT_APPLIKATION")
    public String getSpaClientApplikation() {
        return spaClientApplikation;
    }

    public void setSpaClientApplikation(String spaClientApplikation) {
        this.spaClientApplikation = spaClientApplikation;
    }

    @Basic
    @Column(name = "SPA_CLIENT_VERSION")
    public String getSpaClientVersion() {
        return spaClientVersion;
    }

    public void setSpaClientVersion(String spaClientVersion) {
        this.spaClientVersion = spaClientVersion;
    }



    @Basic
    @Column(name = "SPA_MELDUNG")
    public byte[] getSpaMeldung() {
        return spaMeldung;
    }

    public void setSpaMeldung(byte[] spaMeldung) {
        this.spaMeldung = spaMeldung;
    }

    @Basic
    @Column(name = "SPA_CORRELATION_ID")
    public String getSpaCorrelationId() {
        return spaCorrelationId;
    }

    public void setSpaCorrelationId(String spaCorrelationId) {
        this.spaCorrelationId = spaCorrelationId;
    }

    @Basic
    @Column(name = "SPA_FAULT_TYPE")
    public String getSpaFaultType() {
        return spaFaultType;
    }

    public void setSpaFaultType(String spaFaultType) {
        this.spaFaultType = spaFaultType;
    }

    @Basic
    @Column(name = "SPA_FAULT_CODE")
    public String getSpaFaultCode() {
        return spaFaultCode;
    }

    public void setSpaFaultCode(String spaFaultCode) {
        this.spaFaultCode = spaFaultCode;
    }

    @Basic
    @Column(name = "SPA_DEBUG_INFORMATION")
    public byte[] getSpaDebugInformation() {
        return spaDebugInformation;
    }

    public void setSpaDebugInformation(byte[] spaDebugInformation) {
        this.spaDebugInformation = spaDebugInformation;
    }

    @Basic
    @Column(name = "SPA_SEVERITY")
    public String getSpaSeverity() {
        return spaSeverity;
    }

    public void setSpaSeverity(String spaSeverity) {
        this.spaSeverity = spaSeverity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogEntity that = (LogEntity) o;

        if (spaClientApplikation != null ? !spaClientApplikation.equals(that.spaClientApplikation) : that.spaClientApplikation != null)
            return false;
        if (spaClientVersion != null ? !spaClientVersion.equals(that.spaClientVersion) : that.spaClientVersion != null)
            return false;
        if (spaTimestamp != null ? !spaTimestamp.equals(that.spaTimestamp) : that.spaTimestamp != null) return false;
        if (!Arrays.equals(spaMeldung, that.spaMeldung)) return false;
        if (spaCorrelationId != null ? !spaCorrelationId.equals(that.spaCorrelationId) : that.spaCorrelationId != null)
            return false;
        if (spaFaultType != null ? !spaFaultType.equals(that.spaFaultType) : that.spaFaultType != null) return false;
        if (spaFaultCode != null ? !spaFaultCode.equals(that.spaFaultCode) : that.spaFaultCode != null) return false;
        if (!Arrays.equals(spaDebugInformation, that.spaDebugInformation)) return false;
        if (spaSeverity != null ? !spaSeverity.equals(that.spaSeverity) : that.spaSeverity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = spaClientApplikation != null ? spaClientApplikation.hashCode() : 0;
        result = 31 * result + (spaClientVersion != null ? spaClientVersion.hashCode() : 0);
        result = 31 * result + (spaTimestamp != null ? spaTimestamp.hashCode() : 0);
        result = 31 * result + (spaMeldung != null ? Arrays.hashCode(spaMeldung) : 0);
        result = 31 * result + (spaCorrelationId != null ? spaCorrelationId.hashCode() : 0);
        result = 31 * result + (spaFaultType != null ? spaFaultType.hashCode() : 0);
        result = 31 * result + (spaFaultCode != null ? spaFaultCode.hashCode() : 0);
        result = 31 * result + (spaDebugInformation != null ? Arrays.hashCode(spaDebugInformation) : 0);
        result = 31 * result + (spaSeverity != null ? spaSeverity.hashCode() : 0);
        return result;
    }
}

