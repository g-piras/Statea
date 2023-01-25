package its.statea.webserver.web.v1.payload.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import its.statea.webserver.helper.datamap.DestinationDatamap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DestinationResponse implements DestinationDatamap, Serializable{
    
    private String id;
    private String nameIta;
    private Boolean isAggregate;
    
    public DestinationResponse(String id, String nameIta, Boolean isAggregate) {
        this.id = id;
        this.nameIta = nameIta;
        this.isAggregate = isAggregate;
    }

    public DestinationResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameIta() {
        return nameIta;
    }

    public void setNameIta(String nameIta) {
        this.nameIta = nameIta;
    }

    public Boolean getIsAggregate() {
        return isAggregate;
    }

    public void setIsAggregate(Boolean isAggregate) {
        this.isAggregate = isAggregate;
    }

    @JsonIgnore
    @Override
    public String getDatamapId() {
        
        return id;
    }

    @JsonIgnore
    @Override
    public String getDatamapNameIta() {
        
        return nameIta;
    }

    @JsonIgnore
    @Override
    public Boolean getDatamapIsAggregate() {
        
        return isAggregate;
    }

    @JsonIgnore
    @Override
    public void setDestinationDatamapFields(DestinationDatamap source) {
        
        this.id = source.getDatamapId();        
        this.nameIta = source.getDatamapNameIta();     
        this.isAggregate = source.getDatamapIsAggregate();  
    }
}
