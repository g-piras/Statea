package its.statea.consumerforecasts.queue.fintechapi.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class FintechRecordAbstract {
    
    private String origin;
    private String destination;
    private String type;
    private String typeHotel;
    private String value;
    
    public FintechRecordAbstract(String origin, String destination, String type,
            String typeHotel, String value) {
        this.origin = origin;
        this.destination = destination;
        this.type = type;
        this.typeHotel = typeHotel;
        this.setValue(value);
    }

    public FintechRecordAbstract() {
    }

    @JsonGetter(value = "origin_id")
    public String getOrigin() {
        return origin;
    }

    @JsonSetter(value = "origin_id")
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @JsonGetter(value = "destination")
    public String getDestination() {
        return destination;
    }

    @JsonSetter(value = "destination")
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @JsonGetter(value = "observation_type_id")
    public String getType() {
        return type;
    }

    @JsonSetter(value = "observation_type_id")
    public void setType(String type) {
        this.type = type;
    }

    @JsonGetter(value = "accommodation_type_id")
    public String getTypeHotel() {
        return typeHotel;
    }

    @JsonSetter(value = "accommodation_type_id")
    public void setTypeHotel(String typeHotel) {
        this.typeHotel = typeHotel;
    }

    @JsonGetter(value = "value")
    public String getValue() {
        return value;
    }

    @JsonSetter(value = "value")
    public void setValue(String value) {

        Long tmpValue = Math.round(Double.parseDouble(value));

        if (tmpValue < 0) {

            // signal negative values
            throw new RuntimeException("Value cannot be negative! (" + tmpValue + ")");
        }

        this.value = tmpValue.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((origin == null) ? 0 : origin.hashCode());
        result = prime * result + ((destination == null) ? 0 : destination.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((typeHotel == null) ? 0 : typeHotel.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FintechRecordAbstract other = (FintechRecordAbstract) obj;
        if (origin == null) {
            if (other.origin != null)
                return false;
        } else if (!origin.equals(other.origin))
            return false;
        if (destination == null) {
            if (other.destination != null)
                return false;
        } else if (!destination.equals(other.destination))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (typeHotel == null) {
            if (other.typeHotel != null)
                return false;
        } else if (!typeHotel.equals(other.typeHotel))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "FintechRecordAbstract [origin=" + origin + ", destination=" + destination
                + ", type=" + type + ", typeHotel=" + typeHotel
                + ", value=" + value + "]";
    }
}