package com.finalTask.tsk.entity;

import java.io.Serializable;

public class Entity implements Serializable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
