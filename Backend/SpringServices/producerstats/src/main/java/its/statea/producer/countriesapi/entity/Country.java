package its.statea.producer.countriesapi.entity;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

    private String countryCode;
    private String nameEng;
    private String nameIta;
    private boolean aggregate = false;

    public Country(String countryCode, String nameEng, String nameIta, boolean aggregate) {
        this.countryCode = countryCode;
        this.nameEng = nameEng;
        this.nameIta = nameIta;
        this.aggregate = aggregate;
    }

    public Country() {
    }

    @JsonGetter(value = "nameEng")
    public String getNameEng() {
        return nameEng;
    }

    @JsonGetter(value = "nameIta")
    public String getNameIta() {
        return nameIta;
    }

    @JsonGetter(value = "countryCode")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonGetter
    public boolean isAggregate() {
        return aggregate;
    }

    @JsonSetter(value = "name")
    public void setNameEng(Map<String, Object> nameMap) {
        this.nameEng = (String)nameMap.get("common");
    }

    @JsonSetter(value = "translations")
    public void setNameIta(Map<String, Map<String, String>> translations) {
        this.nameIta = translations.get("ita").get("common");
    }

    @JsonSetter(value = "cca2")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonIgnore
    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    @JsonIgnore
    public void setNameIta(String nameIta) {
        this.nameIta = nameIta;
    }

    @JsonIgnore
    public void setAggregate(boolean aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
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
        Country other = (Country) obj;
        if (countryCode == null) {
            if (other.countryCode != null)
                return false;
        } else if (!countryCode.equals(other.countryCode))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Country [countryCode=" + countryCode + ", nameEng=" + nameEng + ", nameIta=" + nameIta
                + ", aggregate=" + aggregate + "]";
    }
}