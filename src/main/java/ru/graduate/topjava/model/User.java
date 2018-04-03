package ru.graduate.topjava.model;

import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/*@NamedQueries({
        @NamedQuery(name = User.DELETE, query = "DELETE FROM User u WHERE u.id=:id"),
        @NamedQuery(name = User.BY_EMAIL, query = "SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.email=?1"),
        @NamedQuery(name = User.ALL_SORTED, query = "SELECT u FROM User u LEFT JOIN FETCH u.roles ORDER BY u.name, u.email"),
})*/
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "users_unique_email_idx")})
public class User extends AbstractNamedEntity {

//    public static final String DELETE = "User.delete";
//    public static final String BY_EMAIL = "User.getByEmail";
//    public static final String ALL_SORTED = "User.getAllSorted";

//    @Column(name = "email", nullable = false, unique = true)
//    @Email
//    @NotBlank
//    @Size(max = 100)
//    private String email;

//    @Column(name = "password", nullable = false)
//    @NotBlank
//    @Size(min = 5, max = 100)
//    private String password;

//    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
//    private boolean enabled = true;

/*    @Column(name = "registered", columnDefinition = "timestamp default now()")
    @NotNull
    private Date registered = new Date();*/

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

//    @Column(name = "calories_per_day", columnDefinition = "int default 2000")
//    @Range(min = 10, max = 10000)
//    private int caloriesPerDay = DEFAULT_CALORIES_PER_DAY;

    public User() {
    }

    public User(User u) {
//        this(u.getId(), u.getName(), u.getEmail(), u.getPassword(), u.getCaloriesPerDay(), u.isEnabled(), u.getRegistered(), u.getRoles());
    }

    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Collection<Role> roles) {
        Set<Object> objects = Collections.emptySet();
        EnumSet<Role> roles1 = EnumSet.copyOf(roles);
        Set<?> objects1 = CollectionUtils.isEmpty(roles) ? Collections.emptySet() : EnumSet.copyOf(roles);
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