package avitera.model;


import avitera.model.pnr.Flight;
import avitera.model.pnr.Route;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false, unique = true)
    private Long id;

    @Column(name = "company_name")
    private String companyName;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "password", length = 60, nullable = false)
    private String password;
    @Column(name = "credit")
    private Integer credit=0;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles")
    private Set<Role> roles;
    @OneToMany(mappedBy = "user")
    private Set<Route> routes;
    @OneToMany(mappedBy = "user")
    private List<Flight> flightList;

    User(User user) {
        this.id = user.getId();
        this.companyName = user.getCompanyName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.credit = user.getCredit();
        this.roles = user.getRoles();
    }

    public <T> User(String companyName, String email, String userPassword, int creditGift, Set<T> singleton) {
    }

    public User(String email, String encode, Collection<? extends GrantedAuthority> authorities) {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public Set<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(Set<Route> routes) {
        this.routes = routes;
    }
}
