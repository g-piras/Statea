package its.statea.webserver.web.v1.payload.response;

import java.io.Serializable;
import java.time.Year;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import its.statea.webserver.helper.datamap.YearsRangeDatamap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YearsRangeResponse implements YearsRangeDatamap, Serializable {
    
    private Integer startYear;
    private Integer endYear;
    
    public YearsRangeResponse(Year startYear, Year endYear) {
        this.setStartYear(startYear);
        this.setEndYear(endYear);
    }

    public YearsRangeResponse() {
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Year startYear) {
        this.startYear = startYear.getValue();
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Year endYear) {
        this.endYear = endYear.getValue();
    }

    @JsonIgnore
    @Override
    public Year getDatamapStartYear() {
        
        return Year.of(this.startYear);
    }

    @JsonIgnore
    @Override
    public Year getDatamapEndYear() {
        
        return Year.of(this.endYear);
    }

    @JsonIgnore
    @Override
    public void setYearsRangeDatamapFields(YearsRangeDatamap source) {
        
        this.setStartYear(source.getDatamapStartYear());
        this.setEndYear(source.getDatamapEndYear());
    }
}
