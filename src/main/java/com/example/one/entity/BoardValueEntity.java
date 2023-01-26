package com.example.one.entity;

import java.util.Objects;

public class BoardValueEntity {
    private int index;
    private String boardValue;

    public BoardValueEntity() {
    }

    public BoardValueEntity(int index, String boardValue) {
        this.index = index;
        this.boardValue = boardValue;
    }

    public int getIndex() {
        return index;
    }

    public BoardValueEntity setIndex(int index) {
        this.index = index;
        return this;
    }

    public String getBoardValue() {
        return boardValue;
    }

    public BoardValueEntity setBoardValue(String boardValue) {
        this.boardValue = boardValue;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardValueEntity that = (BoardValueEntity) o;
        return index == that.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
