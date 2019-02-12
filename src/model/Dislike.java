package model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by sharanya.p on 1/19/2019.
 */
public class Dislike extends Reaction {

    public Dislike(UUID userId) {
        this.name = "dislike";
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.createDate = new Date();
    }
}
