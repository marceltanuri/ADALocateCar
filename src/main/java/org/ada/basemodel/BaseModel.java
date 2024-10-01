package org.ada.basemodel;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class BaseModel {
    protected final String uuid;
    protected LocalDateTime createdAt;
    protected String createdBy;

    public BaseModel() {
        this.uuid = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

    public String getUuid() {
        return uuid;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
