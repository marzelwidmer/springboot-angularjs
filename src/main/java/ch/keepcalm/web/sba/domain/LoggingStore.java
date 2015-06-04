package ch.keepcalm.web.sba.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * faultTyp :
 * <ul>
 * <li>DATEN</li>
 * <li>SYSTEM_SOFT</li>
 * <li>SYSTEM_SOFT_KOMPATIBILITAET</li>
 * <li>SYSTEM_SOFT_SCHEMA</li>
 * <li>SYSTEM_UMGEBUNG</li>
 * </ul>
 * severity :
 * <ul>
 * <li>DEBUG</li>
 * <li>ERROR</li>
 * <li>INFO</li>
 * <li>WARNING</li>
 * </ul>
 * Beispiel Request
 * <pre>
 *     <code>
 *         {
 *              "clientApplikation": "SPA",
 *              "clientVersion": "1.0",
 *              "correlationId": "11212",
 *              "debugInformation": "Hello World",
 *              "faultMessage": "Helsana Hello World",
 *              "faultCode": "289-36",
 *              "faultType": "DATEN",
 *              "severity": "DEBUG",
 *          }
 *     </code>
 * </pre>
 * Beispiel Response
 * <pre>
 *     <code>
 *         {}
 *     </code>
 * </pre>
 */
@Entity
public class LoggingStore implements Serializable {


    private static final long serialVersionUID = 5873356508976710835L;

    private static final String DEFAULT_MESSAGE = "Es ist ein genereller Fehler aufgetreten";

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TIMESTAMP", nullable = false)
    private Date timestamp;


    @NotEmpty(message = DEFAULT_MESSAGE)
    @NotNull(message = DEFAULT_MESSAGE)
    @Size.List({
            @Size(min = 1),
            @Size(max = 30,
            message = DEFAULT_MESSAGE)
    })
    @Column(name = "CLIENT_APPLIKATION")
    private String clientApplikation;


    @NotEmpty(message = DEFAULT_MESSAGE)
    @NotNull(message = DEFAULT_MESSAGE)
    @Size.List({
            @Size(min = 1),
            @Size(max = 1024,
                    message = DEFAULT_MESSAGE)
    })
    @Column(name = "CLIENT_VERSION")
    private String clientVersion;

    @NotEmpty(message = DEFAULT_MESSAGE)
    @NotNull(message = DEFAULT_MESSAGE)
    @Size.List({
            @Size(min = 1),
            @Size(max = 4000,
                    message = DEFAULT_MESSAGE)
    })
    @Column(name = "DEBUG_INFORMATION")
    private String debugInformation;

    @NotEmpty(message = DEFAULT_MESSAGE)
    @NotNull(message = DEFAULT_MESSAGE)
    @Size.List({
            @Size(min = 1),
            @Size(max = 256,
                    message = DEFAULT_MESSAGE)
    })
    @Column(name = "FAULT_CODE")
    private String faultCode;

    @NotEmpty(message = DEFAULT_MESSAGE)
    @NotNull(message = DEFAULT_MESSAGE)
    @Size(min = 1, max = 4000,
            message = DEFAULT_MESSAGE)
    @Column(name = "FAULT_MESSAGE")
    private String faultMessage;

    /**
     * DATEN / SYSTEM_SOFT / SYSTEM_SOFT_KOMPATIBILITAET / SYSTEM_SOFT_SCHEMA / SYSTEM_UMGEBUNG
     */
    @NotEmpty(message = DEFAULT_MESSAGE)
    @NotNull(message = DEFAULT_MESSAGE)
    @Size.List({
            @Size(min = 1),
            @Size(max = 64,
                    message = DEFAULT_MESSAGE)
    })
    @Pattern(regexp = "\\bDATEN\\b|\\bSYSTEM_SOFT\\b|\\bSYSTEM_SOFT_KOMPATIBILITAET\\b|\\bSYSTEM_SOFT_SCHEMA\\b|\\bSYSTEM_UMGEBUNG\\b", message = DEFAULT_MESSAGE)
    @Column(name = "FAULT_TYPE")
    private String faultType;

    /**
     * DEBUG / ERROR / INFO / WARNING
     */
    @NotEmpty(message = DEFAULT_MESSAGE)
    @NotNull(message = DEFAULT_MESSAGE)
    @Size.List({
            @Size(min = 1),
            @Size(max = 64,
                    message = DEFAULT_MESSAGE)
    })
    @Pattern(regexp = "\\bDEBUG\\b|\\bINFO\\b|\\bERROR\\b|\\bWARNING\\b")
    @Column(name = "SEVERITY")
    private String severity;


    @NotEmpty(message = DEFAULT_MESSAGE)
    @NotNull(message = DEFAULT_MESSAGE)
    @Size.List({
            @Size(min = 1),
            @Size(max = 64,
                    message = DEFAULT_MESSAGE)
    })
    @Column(name = "CORRELATION_ID")
    private String correlationId;


    @PrePersist
    protected void onCreate() {
        timestamp = new Date();
    }


    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public String getClientApplikation() {
        return clientApplikation;
    }

    public void setClientApplikation(String clientApplikation) {
        this.clientApplikation = clientApplikation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public String getDebugInformation() {
        return debugInformation;
    }

    public void setDebugInformation(String debugInformation) {
        this.debugInformation = debugInformation;
    }

    public String getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode;
    }

    public String getFaultMessage() {
        return faultMessage;
    }

    public void setFaultMessage(String faultMessage) {
        this.faultMessage = faultMessage;
    }

    public String getFaultType() {
        return faultType;
    }

    public void setFaultType(String faultType) {
        this.faultType = faultType;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }
}
