package its.statea.producer.istatapi.entity;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class District {
    
    private String id;
    private String name;
    private boolean aggregate = false;

    public District(String id, String name, boolean aggregate) {
        this.id = id;
        this.name = name;
        this.aggregate = aggregate;
    }

    public District() {
    }

    @JsonGetter(value = "id")
    public String getId() {
        return id;
    }

    @JsonGetter(value = "name")
    public String getName() {
        return name;
    }

    @JsonGetter
    public boolean isAggregate() {
        return aggregate;
    }

    @JsonSetter(value = "id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonSetter(value = "name")
    public void setName(Map<String, String> nameMap) {
        this.name = nameMap.get("en");
    }

    @JsonIgnore
    public void setAggregate(boolean aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        District other = (District) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "District [id=" + id + ", name=" + name + ", aggregate=" + aggregate + "]";
    }
}