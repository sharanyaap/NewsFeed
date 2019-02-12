import api.NewsFeed;
import model.User;
import service.NewsFeedService;

import java.util.Scanner;
import java.util.UUID;

/**
 * Created by sharanya.p on 1/19/2019.
 */
public class NewsFeedSystem {


    public static void main(String[] args) {

        NewsFeed feedService = new NewsFeedService();
        User loginUser;


        //Test Case 1

        feedService.createUser("lucious");

        feedService.createUser("albus");
        feedService.createUser("tom");

        loginUser = feedService.getUserByName("tom");

        feedService.postFeed(loginUser.getId(), "Tes data1");
        feedService.postFeed(loginUser.getId(), "Tes data2");

        loginUser = feedService.getUserByName("lucious");

        feedService.showFeed(loginUser.getId());

        // Test Case 2

        Scanner sc = new Scanner(System.in);


        // String input
        System.out.println("Enter Post Id to Like");
        String postId = sc.nextLine();
        feedService.react(loginUser.getId(), UUID.fromString(postId), "like");

        System.out.println("Enter User to follow");
        String username = sc.nextLine();
        feedService.followUser(loginUser.getId(), username);

        System.out.println("Enter Comment");
        String comment = sc.nextLine();
        feedService.addComment(loginUser.getId(), UUID.fromString(postId), comment);

        System.out.println("Enter Login username");
        String loginuser = sc.nextLine();
        loginUser = feedService.getUserByName(loginuser);

        feedService.showFeed(loginUser.getId());

        // Test Case 3

        System.out.println("Enter Post");
        String postdata = sc.nextLine();
        feedService.postFeed(loginUser.getId(), postdata);

        System.out.println("Enter User to follow");
        username = sc.nextLine();
        feedService.followUser(loginUser.getId(), username);

        System.out.println("Enter Post Id to dislike");
        postId = sc.nextLine();
        feedService.react(loginUser.getId(), UUID.fromString(postId), "dislike");

        System.out.println("Enter Post Id to dislike");
        postId = sc.nextLine();
        feedService.react(loginUser.getId(), UUID.fromString(postId), "dislike");


        System.out.println("Enter Comment");
        comment = sc.nextLine();
        feedService.addComment(loginUser.getId(), UUID.fromString(postId), comment);

        feedService.showFeed(loginUser.getId());


    }

}
