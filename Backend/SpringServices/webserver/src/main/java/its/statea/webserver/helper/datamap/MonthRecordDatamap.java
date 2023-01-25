package its.statea.webserver.helper.datamap;

import java.time.LocalDate;

import its.statea.webserver.web.v1.payload.response.AccommodationTypeResponse;
import its.statea.webserver.web.v1.payload.response.DestinationResponse;
import its.statea.webserver.web.v1.payload.response.ObservationTypeResponse;
import its.statea.webserver.web.v1.payload.response.OriginResponse;

public interface MonthRecordDatamap {
    
    public OriginResponse getDatamapOrigin();
    public DestinationResponse getDatamapDestination();
    public AccommodationTypeResponse getDatamapAccommodationType();
    public ObservationTypeResponse getDatamapObservationType();
    public LocalDate getDatamapDate();
    public Long getDatamapValue();

    public void setMonthRecordDatamapFields(MonthRecordDatamap source);
}
