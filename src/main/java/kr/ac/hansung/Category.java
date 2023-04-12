package kr.ac.hansung;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
//@ToString
@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private int id;

    private String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //Lazy와 Eager의 차이 알아야..
    private Set<Product> products = new HashSet<>();

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
