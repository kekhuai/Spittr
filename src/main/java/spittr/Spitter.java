package spittr;

import java.util.Objects;

public class Spitter {
    
    private Long id;
    
    private String username;
    
    private String password;
    
    private String firstName;
    
    private String lastName;

    public Spitter() {
        super();
    }

    public Spitter(String username, String password, String firstName, String lastName) {
        this(null, username, password, firstName, lastName);
    }

    public Spitter(Long id, String username, String password, String firstName, String lastName) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Spitter)) {
            return false;
        }
        Spitter castOther = (Spitter) other;
        return Objects.equals(username, castOther.username) && Objects.equals(password, castOther.password)
                && Objects.equals(firstName, castOther.firstName) && Objects.equals(lastName, castOther.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, firstName, lastName);
    }

}
