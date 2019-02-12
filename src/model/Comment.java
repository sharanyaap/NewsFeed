package model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by sharanya.p on 1/19/2019.
 */
public class Comment {

    UUID id;

    Date createDate;

    String data;

    UUID userId;

    UUID postId;

    UUID commentId;

    public Comment(String data, UUID userId, UUID postId) {
        this.data = data;
        this.userId = userId;
        this.postId = postId;
        this.id = UUID.randomUUID();
        this.createDate = new Date();
    }

    public Comment(String data, UUID userId, UUID postId, UUID commentId) {
        this.data = data;
        this.userId = userId;
        this.postId = postId;
        this.commentId = commentId;
        this.id = UUID.randomUUID();
        this.createDate = new Date();
    }

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public UUID getCommentId() {
        return commentId;
    }

    public void setCommentId(UUID commentId) {
        this.commentId = commentId;
    }
}
