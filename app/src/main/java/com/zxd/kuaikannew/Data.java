package com.zxd.kuaikannew;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<String> week_days;

    private int pos;

    private List<Topics> topics;

    public void setWeek_days(List<String> week_days) {
        this.week_days = week_days;
    }

    public List<String> getWeek_days() {
        return this.week_days;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getPos() {
        return this.pos;
    }

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }

    public List<Topics> getTopics() {
        return this.topics;
    }
}