package model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by sharanya.p on 1/19/2019.
 */
public class Like extends Reaction {

    public Like(UUID userId) {
        this.name = "like";
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.createDate = new Date();
    }
}
