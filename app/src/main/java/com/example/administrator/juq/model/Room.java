package com.example.administrator.juq.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2017/3/29.
 */

public class Room {
    private UUID mId;
    private Date mDate;
    private Location mLocation;
    private User mUser;

    public Room() {
        this(UUID.randomUUID());
    }

    public Room(UUID id) {
        mId = id;
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public Location getLocation() {
        return mLocation;
    }

    public void setLocation(Location location) {
        this.mLocation = location;
    }

}
