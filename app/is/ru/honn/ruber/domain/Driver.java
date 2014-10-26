package is.ru.honn.ruber.domain;

/**
 * Created by arnif on 10/25/14.
 */
public class Driver {

    private int id;
    private String userName;
    private String firstName;
    private String lastName;
    private String description;
    private String displayName;
    private int capacity;
    private String image;
    private Price price;

    public Driver(int id, String userName, String firstName, String lastName, String description, String displayName, int capacity, String image, Price price) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.displayName = displayName;
        this.capacity = capacity;
        this.image = image;
        this.price = price;
    }

    public Driver(String userName, String firstName, String lastName, String description, String displayName, int capacity, String image) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.displayName = displayName;
        this.capacity = capacity;
        this.image = image;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
