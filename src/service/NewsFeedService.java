package service;

import api.NewsFeed;
import model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Created by sharanya.p on 1/19/2019.
 */
public class NewsFeedService implements NewsFeed {

    List<PostData> postDatas = new ArrayList<>();

    List<User> signUpUsers = new ArrayList<>();

    List<UserFollow> followList = new ArrayList<>();

    @Override
    public List<PostData> showFeed(UUID userId) {
        List<UUID> followers = findFollowers(userId);
        List<PostData> feedPosts = findPostsByFollowers(followers);

        if (feedPosts != null && !feedPosts.isEmpty()) {
            Collections.sort(feedPosts);
            Collections.reverse(feedPosts);

            for (PostData postData : feedPosts) {
                System.out.println("id :: " + postData.getPost().getId());
                System.out.println(postData.getLikes() + " upVotes, " + postData.getDisLikes() + " downVotes");
                System.out.println(postData.getPost().getUserId());
                System.out.println(postData.getPost().getData());
                System.out.println(postData.getPost().getCreateDate());
                System.out.println("Comments :: ");

                for (Comment comment : postData.getComments()){
                    System.out.println(comment.getUserId());
                    System.out.println(comment.getData());
                    System.out.println(comment.getCreateDate());
                }
            }
        }

        return null;
    }

    private List<PostData> findPostsByFollowers(List<UUID> uuids) {
        List<PostData> feedPosts = new ArrayList<>();
        for (PostData postData : postDatas) {
            if (uuids != null && !uuids.isEmpty() && uuids.contains(postData.getPost().getUserId())) {
                feedPosts.add(postData);
            }
        }
        for (PostData postData : postDatas) {
            if (!feedPosts.contains(postData)) {
                feedPosts.add(postData);
            }
        }
        return feedPosts;
    }

    private List<UUID> findFollowers(UUID userId) {
        List<UUID> followers = new ArrayList<>();
        for (UserFollow userFollow : followList) {
            if (userFollow.getUserId().equals(userId)) {
                followers.add(userFollow.getFollowUserId());
            }
        }
        return followers;
    }

    @Override
    public void createUser(String userName) {
        // TODO check if username exists
        User user = new User(userName);
        signUpUsers.add(user);
    }

    @Override
    public void followUser(UUID userId, String followUser) {
        User follow = null;
        for (User user : signUpUsers) {
            if (followUser.equalsIgnoreCase(user.getUsername())) {
                follow = user;
                break;
            }
        }
        UserFollow userFollow;
        if (follow != null) {
            userFollow = new UserFollow(userId, follow.getId());
            if (!followList.contains(userFollow)) {
                followList.add(userFollow);
            }
        }
    }

    @Override
    public void postFeed(UUID userId, String data) {
        Post post = new Post(userId, data);
        PostData postData = new PostData(post);
        postDatas.add(postData);
    }

    @Override
    public void addComment(UUID userId, UUID postId, String data) {
        Comment comment = new Comment(data, userId, postId);
        for (PostData postData : postDatas) {
            if (postData.getPost().getId().equals(postId)) {
                postData.addComment(comment);
            }
        }
    }

    @Override
    public void react(UUID userId, UUID postId, String type) {
        Reaction reaction = null;
        if ("like".equalsIgnoreCase(type))
            reaction = new Like(userId);
        else if ("disLike".equalsIgnoreCase(type))
            reaction = new Dislike(userId);
        else
            System.out.println("Enter valid reaction type");
        if (reaction != null) {
            for (PostData data : postDatas) {
                if (data.getPost().getId().equals(postId)) {
                    data.addReaction(reaction);
                }
            }
        }
    }


    @Override
    public User getUserByName(String name) {
        if (name != null && !name.isEmpty()) {
            for (User user : signUpUsers) {
                if (name.equalsIgnoreCase(user.getUsername())) {
                    return user;
                }
            }
        }
        return null;
    }
}
