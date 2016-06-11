package ru.testproject2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Анатолий on 09.06.2016.
 */
@Entity
@Table(name = "categories")
public class   Category extends BasedEntity {

    @Column(name = "name")
    private String name;

    public Category() {
    }

    public Category(int id, String name) {
        this.setId(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
