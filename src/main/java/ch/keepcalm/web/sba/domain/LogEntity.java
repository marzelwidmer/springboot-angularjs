package ch.keepcalm.web.sba.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hkesq on 01.06.2015.
 */
@Entity
//@Table (name = "LOG_ENTITY")
public class LogEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Basic
    @Column(name = "CLIENT_APPLIKATION")
    private String clientApplikation;
    @Basic
    @Column(name = "CLIENT_VERSION")
    private String clientVersion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TIMESTAMP", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date timestamp;

    @Column(name = "MELDUNG")
    private String meldung;

    @Column(name = "CORRELATION_ID")
    private String correlationId;

    @Column(name = "FAULT_TYPE")
    private String faultType;

    @Column(name = "FAULT_CODE")
    private String faultCode;

    @Column(name = "DEBUG_INFORMATION")
    private String debugInformation;

    @Column(name = "SEVERITY")
    private String severity;


    @PrePersist
    protected void onCreate() {
        timestamp = new Date();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


    public String getClientApplikation() {
        return clientApplikation;
    }

    public void setClientApplikation(String clientApplikation) {
        this.clientApplikation = clientApplikation;
    }


    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }


    public String getMeldung() {
        return meldung;
    }

    public void setMeldung(String meldung) {
        this.meldung = meldung;
    }


    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }


    public String getFaultType() {
        return faultType;
    }

    public void setFaultType(String faultType) {
        this.faultType = faultType;
    }


    public String getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode;
    }

    public String getDebugInformation() {
        return debugInformation;
    }

    public void setDebugInformation(String debugInformation) {
        this.debugInformation = debugInformation;
    }


    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogEntity that = (LogEntity) o;

        if (clientApplikation != null ? !clientApplikation.equals(that.clientApplikation) : that.clientApplikation != null)
            return false;
        if (clientVersion != null ? !clientVersion.equals(that.clientVersion) : that.clientVersion != null)
            return false;
        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;
        if (meldung != null ? !meldung.equals(that.meldung) : that.meldung != null) return false;

        if (correlationId != null ? !correlationId.equals(that.correlationId) : that.correlationId != null)
            return false;
        if (faultType != null ? !faultType.equals(that.faultType) : that.faultType != null) return false;
        if (faultCode != null ? !faultCode.equals(that.faultCode) : that.faultCode != null) return false;
        if (debugInformation != null ? !debugInformation.equals(that.debugInformation) : that.debugInformation != null)
            return false;

        if (severity != null ? !severity.equals(that.severity) : that.severity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientApplikation != null ? clientApplikation.hashCode() : 0;
        result = 31 * result + (clientVersion != null ? clientVersion.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (meldung != null ? meldung.hashCode() : 0);
        result = 31 * result + (correlationId != null ? correlationId.hashCode() : 0);
        result = 31 * result + (faultType != null ? faultType.hashCode() : 0);
        result = 31 * result + (faultCode != null ? faultCode.hashCode() : 0);
        result = 31 * result + (debugInformation != null ? debugInformation.hashCode() : 0);
        result = 31 * result + (severity != null ? severity.hashCode() : 0);
        return result;
    }
}

