package its.statea.webserver.web.v1.payload.request.paramEnum;

public enum OriginSortEnum {
    
    id("id"), 
    nameIta("nameIta"), 
    nameEng("nameEng");

    private final String fieldName;

    private OriginSortEnum(String fieldName) {

        this.fieldName = fieldName;
    }

    @Override
    public String toString() {

        return this.fieldName;
    }
}
