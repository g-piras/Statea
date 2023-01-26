package its.statea.webserver.web.v1.payload.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import its.statea.webserver.helper.datamap.DatesRangeDatamap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatesRangeResponse implements DatesRangeDatamap, Serializable {
    
    private String startDate;
    private String endDate;
    
    public DatesRangeResponse(LocalDate startDate, LocalDate endDate) {
        this.setStartDate(startDate);
        this.setEndDate(endDate);
    }

    public DatesRangeResponse() {
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate.format(DateTimeFormatter.ISO_DATE);
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate.format(DateTimeFormatter.ISO_DATE);
    }

    @JsonIgnore
    @Override
    public LocalDate getDatamapStartDate() {

        return LocalDate.parse(this.startDate);
    }

    @JsonIgnore
    @Override
    public LocalDate getDatamapEndDate() {
        
        return LocalDate.parse(this.endDate);
    }

    @JsonIgnore
    @Override
    public void setDatesRangeDatamapFields(DatesRangeDatamap source) {
        
        this.setStartDate(source.getDatamapStartDate());
        this.setEndDate(source.getDatamapEndDate());
    }
}
