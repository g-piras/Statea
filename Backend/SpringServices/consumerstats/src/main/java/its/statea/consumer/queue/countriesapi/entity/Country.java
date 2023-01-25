package its.statea.consumer.queue.countriesapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    public String getNameIta() {
        return nameIta;
    }

    public void setNameIta(String nameIta) {
        this.nameIta = nameIta;
    }

    public boolean isAggregate() {
        return aggregate;
    }

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
        return "Country [countryCode=" + countryCode + ", nameEng=" + nameEng + ", nameIta=" + nameIta + ", aggregate="
                + aggregate + "]";
    }
}