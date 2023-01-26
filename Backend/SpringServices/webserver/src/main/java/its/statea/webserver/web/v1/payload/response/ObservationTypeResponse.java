package its.statea.webserver.web.v1.payload.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import its.statea.webserver.helper.datamap.ObservationTypeDatamap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ObservationTypeResponse implements ObservationTypeDatamap, Serializable {
    
    private String id;
    private String name;
    
    public ObservationTypeResponse(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public ObservationTypeResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    @Override
    public String getDatamapId() {

        return this.id;
    }

    @JsonIgnore
    @Override
    public String getDatamapName() {

        return this.name;
    }

    @JsonIgnore
    @Override
    public void setObservationTypeDatamapFields(ObservationTypeDatamap source) {
    
        this.id = source.getDatamapId();
        this.name = source.getDatamapName();
    }
}
