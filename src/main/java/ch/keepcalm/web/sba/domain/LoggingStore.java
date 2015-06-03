package ch.keepcalm.web.sba.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class LoggingStore implements Serializable {


    private static final long serialVersionUID = 5873356508976710835L;


    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;


    @NotEmpty
    @NotNull
    @Size(min=1, max=30)
    @Column(name = "CLIENT_APPLIKATION")
    private String clientApplikation;


    @NotEmpty
    @NotNull
    @Size(min=1, max=1024)
    @Column(name = "CLIENT_VERSION")
    private String clientVersion;






    public String getClientVersion() {
        return clientVersion;
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


}
