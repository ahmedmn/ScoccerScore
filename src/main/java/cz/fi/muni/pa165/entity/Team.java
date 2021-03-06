package cz.fi.muni.pa165.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Team class is the base class storing and retrieving information about
 * each team.
 * @author sokdina999@gamil.com
**/

@Entity
public class Team {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private int id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="city")
    private String city;

    @Column(name="country")
    private String country;
    
    @OneToMany
    private Set<Player> players;

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public int getId() {
            return id;
    }

    public void setId(int id) {
            this.id = id;
    }

    public String getName() {
            return name;
    }

    public void setName(String Name) {
            this.name = Name;
    }

    public String getCity() {
            return city;
    }

    public void setCity(String city) {
            this.city = city;
    }

    public String getCountry() {
            return country;
    }

    public void setCountry(String country) {
            this.country = country;
    }

    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
    }

    @Override
    public boolean equals(Object obj) {
            if (this == obj)
                    return true;
            if (obj == null)
                    return false;
            if (!(obj instanceof Team))
                    return false;
            Team other = (Team) obj;
            if (name == null) {
                    if (other.name != null)
                            return false;
            } else if (!name.equals(other.getName()))
                    return false;
            return true;
    }	
}
