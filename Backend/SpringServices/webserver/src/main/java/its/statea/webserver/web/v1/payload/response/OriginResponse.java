package its.statea.webserver.web.v1.payload.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import its.statea.webserver.helper.datamap.OriginDatamap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OriginResponse implements OriginDatamap, Serializable {
    
    private String id;
    private String nameIta;
    private String nameEng;
    private Boolean isAggregate;
    
    public OriginResponse(String id, String nameIta, String nameEng, Boolean isAggregate) {
        this.id = id;
        this.nameIta = nameIta;
        this.nameEng = nameEng;
        this.isAggregate = isAggregate;
    }

    public OriginResponse() {
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

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
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
    public String getDatamapNameEng() {
        
        return nameEng;
    }

    @JsonIgnore
    @Override
    public Boolean getDatamapIsAggregate() {
        
        return isAggregate;
    }

    @JsonIgnore
    @Override
    public void setOriginDatamapFields(OriginDatamap source) {
        
        this.id = source.getDatamapId();        
        this.nameIta = source.getDatamapNameIta();        
        this.nameEng = source.getDatamapNameEng();        
        this.isAggregate = source.getDatamapIsAggregate();  
    }
}
