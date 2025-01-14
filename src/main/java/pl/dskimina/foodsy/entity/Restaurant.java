package pl.dskimina.foodsy.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "restaurant_id", unique = true, nullable = false, length = 512)
    private String restaurantId;

    @Column(name = "name", nullable = false, length = 512)
    private String name;

    @Column(name="phone", nullable = false, length = 512)
    private String phone;

    @Column(name="description", nullable = true, length = 512)
    private String description;

    @Column(name = "image", nullable = true)
    private byte[] image;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<MenuItem> menuItems;

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String restaurantName) {
        this.name = restaurantName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
