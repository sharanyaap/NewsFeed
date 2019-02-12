package model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by sharanya.p on 1/19/2019.
 */
public class Reaction {

    UUID id;

    Date createDate;

    String name;

    UUID userId;

    /*public Reaction(String name, UUID userId) {
        this.name = name;
        this.userId = userId;
        this.id = UUID.randomUUID();
        this.createDate = new Date();
    }*/

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
