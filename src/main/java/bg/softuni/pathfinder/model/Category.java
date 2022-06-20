package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.CategoryTypes;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryTypes name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public CategoryTypes getName() {
        return name;
    }

    public void setName(CategoryTypes name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
