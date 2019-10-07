package at.htl.coincollection.model;

import javax.persistence.*;

@Entity
@NamedQueries(
        @NamedQuery(name="Collector.getAll", query="select c from Collector c")
)
public class Collector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    //region Constructors

    public Collector() {
    }

    public Collector(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //endregion

    //region Getter and Setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //endregion

}
