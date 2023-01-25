package its.statea.webserver.helper.datamap;

public interface DestinationDatamap {
    
    public String getDatamapId();
    public String getDatamapNameIta();
    public Boolean getDatamapIsAggregate();

    public void setDestinationDatamapFields(DestinationDatamap source);
}
