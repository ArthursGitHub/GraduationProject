package ru.graduate.topjava.model;

import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = User.DELETE, query = "DELETE FROM User u WHERE u.id=:id"),
        @NamedQuery(name = User.ALL_SORTED, query = "SELECT u FROM User u ORDER BY u.name"),
})
@Entity
@Table(name = "users")
public class User extends AbstractNamedEntity {

  public static final String DELETE = "User.delete";
  public static final String ALL_SORTED = "User.getAllSorted";

  @Enumerated(EnumType.STRING)
  @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
  @Column(name = "role")
  @ElementCollection(fetch = FetchType.EAGER)
  private Set<Role> roles;

  public User() {
  }

  public User(Integer id, String name, Role role, Role... roles) {
    super(id, name);
    setRoles(EnumSet.of(role, roles));
  }

  public Set<Role> getRoles() {
    return roles;
  }
  public void setRoles(Collection<Role> roles) {
    this.roles = CollectionUtils.isEmpty(roles) ? Collections.emptySet() : EnumSet.copyOf(roles);
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", name=" + name +
            ", roles=" + roles +
            '}';
  }
}
