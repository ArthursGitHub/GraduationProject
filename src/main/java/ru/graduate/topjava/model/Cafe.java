package ru.graduate.topjava.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
        @NamedQuery(name = Cafe.DELETE, query = "DELETE FROM Cafe c WHERE c.id=:id"),
        @NamedQuery(name = Cafe.ALL_SORTED, query = "SELECT c FROM Cafe c ORDER BY c.name"),
})
@Entity
@Table(name = "cafe")
public class Cafe extends AbstractNamedEntity {

  public static final String DELETE = "Cafe.delete";
  public static final String ALL_SORTED = "Cafe.getAllSorted";

  public Cafe() {
  }
  public Cafe(Integer id, String name) {
    super(id, name);
  }

  @Override
  public String toString() {
    return "Cafe {" +
            "\nid = " + id +
            "\nname = " + name +
            "\n}";
  }
}
