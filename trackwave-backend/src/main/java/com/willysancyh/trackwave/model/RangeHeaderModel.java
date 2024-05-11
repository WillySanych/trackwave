package com.willysancyh.trackwave.model;

public class RangeHeaderModel {
    private long rangeFrom;
    private long rangeTo;

    public RangeHeaderModel(long rangeFrom, long rangeTo) {
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
    }

    public long getRangeFrom() {
        return rangeFrom;
    }

    public void setRangeFrom(long rangeFrom) {
        this.rangeFrom = rangeFrom;
    }

    public long getRangeTo() {
        return rangeTo;
    }

    public void setRangeTo(long rangeTo) {
        this.rangeTo = rangeTo;
    }

    @Override
    public String toString() {
        return "RangeHeaderModel{" +
                "rangeFrom=" + rangeFrom +
                ", rangeTo=" + rangeTo +
                '}';
    }
}
