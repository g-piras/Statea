package its.statea.consumer.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Origin {
 
    @Id
    @Column(nullable = false, length = 20)
    private String id;
    @Column(nullable = false, length = 255)
    private String nameIta;
    @Column(nullable = false, length = 255)
    private String nameEng;
    @Column(nullable = false)
    private Boolean isAggregate;
    
    public Origin(String id, String nameIta, String nameEng, Boolean isAggregate) {
        this.id = id;
        this.nameIta = nameIta;
        this.nameEng = nameEng;
        this.isAggregate = isAggregate;
    }

    public Origin() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameIta() {
        return nameIta;
    }

    public void setNameIta(String nameIta) {
        this.nameIta = nameIta;
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    public Boolean getIsAggregate() {
        return isAggregate;
    }

    public void setIsAggregate(Boolean isAggregate) {
        this.isAggregate = isAggregate;
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
        Origin other = (Origin) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Origin [id=" + id + ", nameIta=" + nameIta + ", nameEng=" + nameEng + ", isAggregate=" + isAggregate
                + "]";
    }
}
