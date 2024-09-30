package br.edu.g2.locacaoDeVeiculos.model;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class BaseModel {

    protected String uuid;
    protected LocalDateTime createdDate;

    public BaseModel() {
        this.uuid = UUID.randomUUID().toString();
    }

    public String getUuid() {
        return uuid.substring(0,8);
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

}