package its.statea.webserver.helper.datamap;

import java.time.Year;

import its.statea.webserver.web.v1.payload.response.AccommodationTypeResponse;
import its.statea.webserver.web.v1.payload.response.DestinationResponse;
import its.statea.webserver.web.v1.payload.response.ObservationTypeResponse;
import its.statea.webserver.web.v1.payload.response.OriginResponse;

public interface YearRecordDatamap {
    
    public OriginResponse getDatamapOrigin();
    public DestinationResponse getDatamapDestination();
    public AccommodationTypeResponse getDatamapAccommodationType();
    public ObservationTypeResponse getDatamapObservationType();
    public Year getDatamapYear();
    public Long getDatamapValue();

    public void setYearRecordDatamapFields(YearRecordDatamap source);
}
