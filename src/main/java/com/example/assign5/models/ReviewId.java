package com.example.assign5.models;

import java.io.Serializable;

public class ReviewId implements Serializable  {
    private long userId;
    private long sectionId;
    public int hashCode() {
        return (int)(userId + sectionId);
    }

    public boolean equals(Object object) {
        if (object instanceof ReviewId) {
            ReviewId otherId = (ReviewId) object;
            return (otherId.userId == this.userId) && (otherId.sectionId == this.sectionId);
        }
        return false;
    }
}
