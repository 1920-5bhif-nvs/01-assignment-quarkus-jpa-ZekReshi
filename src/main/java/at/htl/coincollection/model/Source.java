package at.htl.coincollection.model;

import javax.persistence.*;

@Entity
@NamedQueries(
        @NamedQuery(name="Source.getAll", query="select s from Source s")
)
@NamedEntityGraph(
        name = "source-entity-graph",
        attributeNodes = {
                @NamedAttributeNode("name")
        }
)
public class Source {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //region Constructors

    public Source() {
    }

    public Source(String name) {
        this.name = name;
    }

    //endregion

    //region Getter and Setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //endregion

}
