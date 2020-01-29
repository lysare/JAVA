package plan;

import javax.persistence.*;

@Entity
@Table(name = "Professions")
public class Professions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "profession")
    private String profession;


    private String user_name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Users user;

    public Professions() {
    }

    public Professions(String profession, String user_name) {
        this.profession = profession;
        this.user_name = user_name;
    }

    public static void remove(Professions profession) {
    }

    public int getId() {
        return id;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return user_name + " " + profession;
    }

    public void add(Professions profession) {
    }
}