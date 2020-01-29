package plan;


        import javax.persistence.*;
        import java.util.ArrayList;
        import java.util.List;

@Entity
@Table (name = "user")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    private int age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Professions> profession;

    public Users() {
    }

    public Users(String name, int age) {
        this.name = name;
        this.age = age;
        profession = new ArrayList();
    }

    public void addProfessions(Professions profession) {
        profession.setUser(this);
        profession.add(profession);
    }

    public void removeProfessions(Professions profession) {
        Professions.remove(profession);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Professions> getProfessions() {
        return profession;
    }

    public void setProfessions(List<Professions> profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "models.User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
