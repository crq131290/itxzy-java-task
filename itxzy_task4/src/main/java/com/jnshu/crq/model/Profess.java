package com.jnshu.crq.model;

public class Profess {
    private long id;
    private int type;
    private int diff;
    private int need;
    private String tip;
    private int current;
    private int threshold;
    private String name;
    private String description;
    private long createAt;
    private long updateAt;

    @Override
    public String toString() {
        return "Profess{" + "id=" + id + ", type=" + type + ", diff=" + diff + ", need=" + need + ", tip='" + tip + '\'' + ", current=" + current + ", threshold=" + threshold + ", name='" + name + '\'' + ", description='" + description + '\'' + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }

    public int getNeed() {
        return need;
    }

    public void setNeed(int need) {
        this.need = need;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }
}
