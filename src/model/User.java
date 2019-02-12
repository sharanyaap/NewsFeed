package model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by sharanya.p on 1/19/2019.
 */
public class User {

    UUID id;

    String name;

    String username;

    Date createDate;

    public User(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.username = name;
        this.createDate = new Date();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
