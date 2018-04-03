package ru.graduate.topjava.model;

import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "users_unique_email_idx")})
public class User extends AbstractNamedEntity {

  @Enumerated(EnumType.STRING)
  @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
  @Column(name = "role")
  @ElementCollection(fetch = FetchType.EAGER)
  private Set<Role> roles;

  public User() {
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
