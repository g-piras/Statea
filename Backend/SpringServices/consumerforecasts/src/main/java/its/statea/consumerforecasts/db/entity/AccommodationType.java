package its.statea.consumerforecasts.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class AccommodationType {
    
    @Id
    @Column(nullable = false, length = 20 )
    private String id;
    @Column(nullable = false, length = 150)
    private String name;
    
    public AccommodationType(String id) {
        this.id = id;
    }

    public AccommodationType(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public AccommodationType() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        AccommodationType other = (AccommodationType) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AccommodationType [id=" + id + ", name=" + name + "]";
    }
}
