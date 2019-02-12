package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanya.p on 1/19/2019.
 */
public class PostData implements Comparable<PostData> {

    Post post;

    List<Comment> comments;

    List<Reaction> reactions;

    public PostData(Post post) {
        this.post = post;
        this.comments = new ArrayList<>();
        this.reactions = new ArrayList<>();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void addReaction(Reaction reaction) {
        reactions.add(reaction);
    }

    public int getLikes() {
        int result = 0;
        for (Reaction reaction : reactions) {
            if ("like".equalsIgnoreCase(reaction.getName())) {
                result++;
            }
        }
        return result;
    }

    public int getDisLikes() {
        int result = 0;
        for (Reaction reaction : reactions) {
            if ("dislike".equalsIgnoreCase(reaction.getName())) {
                result++;
            }
        }
        return result;
    }

    public int getScore() {
        int result = 0;
        for (Reaction reaction : reactions) {
            if ("like".equalsIgnoreCase(reaction.getName())) {
                result++;
            } else if ("dislike".equalsIgnoreCase(reaction.getName())) {
                result--;
            }
        }
        return result;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(List<Reaction> reactions) {
        this.reactions = reactions;
    }

    @Override
    public int compareTo(PostData o) {
        int likes = this.getScore() - o.getScore();
        int commentScore = this.getComments().size() - o.getComments().size();

        // TODO sort by createDate

        return likes + commentScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostData postData = (PostData) o;

        if (!post.equals(postData.post)) return false;
        if (comments != null ? !comments.equals(postData.comments) : postData.comments != null) return false;
        return reactions != null ? reactions.equals(postData.reactions) : postData.reactions == null;
    }

    @Override
    public int hashCode() {
        return post.hashCode();
    }
}
