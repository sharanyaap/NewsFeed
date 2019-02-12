package model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by sharanya.p on 1/19/2019.
 */
public class Post {

    UUID id;

    UUID userId;

    String data;

    Date createDate;

    Date updateDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (!id.equals(post.id)) return false;
        if (!userId.equals(post.userId)) return false;
        if (!data.equals(post.data)) return false;
        if (createDate != null ? !createDate.equals(post.createDate) : post.createDate != null) return false;
        return updateDate != null ? updateDate.equals(post.updateDate) : post.updateDate == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + userId.hashCode();
        result = 31 * result + data.hashCode();
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        return result;
    }

    public Post(UUID userId, String data) {
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.data = data;
        createDate = new Date();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
