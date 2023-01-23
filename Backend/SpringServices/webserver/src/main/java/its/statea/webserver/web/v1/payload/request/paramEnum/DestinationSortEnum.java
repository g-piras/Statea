package its.statea.webserver.web.v1.payload.request.paramEnum;

public enum DestinationSortEnum {
    
    id("id"), 
    nameIta("nameIta");

    private final String fieldName;

    private DestinationSortEnum(String fieldName) {

        this.fieldName = fieldName;
    }

    @Override
    public String toString() {

        return this.fieldName;
    }
}
