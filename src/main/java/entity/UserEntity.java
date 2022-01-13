package entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQuery(name = "User.byName", query = "select u from UserEntity u where u.name = ?1")
@Table(name = "user", schema = "hibernate_db")
public class UserEntity {
    private long id;
    private String name;
    @OneToMany(mappedBy = "userId")
    private List<PostEntity> posts;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "userId")
    public List<PostEntity> getPosts() {
        return posts;
    }

    public void setPosts(List<PostEntity> posts) {
        this.posts = posts;
    }
}
