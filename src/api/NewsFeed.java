package api;

import model.PostData;
import model.User;

import java.util.List;
import java.util.UUID;

/**
 * Created by sharanya.p on 1/19/2019.
 */
public interface NewsFeed {

    void createUser(String userName);

    void followUser(UUID userId, String followUser);

    void postFeed(UUID userId, String data);

    void addComment(UUID userId, UUID postId, String comment);

    void react(UUID userId, UUID postId, String type);

    List<PostData> showFeed(UUID userId);

    User getUserByName(String name);

}
