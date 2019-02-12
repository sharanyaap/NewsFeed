package model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by sharanya.p on 1/19/2019.
 */
public class UserFollow {

    UUID userId;

    UUID followUserId;

    Date createDate;

    public UserFollow(UUID userId, UUID followUserId) {
        this.userId = userId;
        this.followUserId = followUserId;
        createDate = new Date();
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getFollowUserId() {
        return followUserId;
    }

    public void setFollowUserId(UUID followUserId) {
        this.followUserId = followUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserFollow that = (UserFollow) o;

        if (!userId.equals(that.userId)) return false;
        return followUserId.equals(that.followUserId);
    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + followUserId.hashCode();
        return result;
    }
}
