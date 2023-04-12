package kr.ac.hansung;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private int id;

    private String name;

}
