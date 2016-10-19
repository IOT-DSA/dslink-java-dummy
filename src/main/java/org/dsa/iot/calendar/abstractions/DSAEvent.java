package org.dsa.iot.calendar.abstractions;

import java.util.Date;
import java.util.TimeZone;

public class DSAEvent {
    private String uniqueId;
    private String title;
    private String description;
    private Date start;
    private Date end;
    private String timeZone;
    private DSAIdentifier calendarIdentifier;
    private boolean readOnly;
    private String location;

    public DSAEvent(String title) {
        this.title = title;
        timeZone = TimeZone.getDefault().getID();
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getStart() {
        return new Date(start.getTime());
    }

    public Date getEnd() {
        return new Date(end.getTime());
    }

    public String getTimeZone() {
        return timeZone;
    }

    public DSAIdentifier getCalendar() {
        return calendarIdentifier;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public String getLocation() {
        return location;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStart(Date start) {
        this.start = new Date(start.getTime());
    }

    public void setEnd(Date end) {
        this.end = new Date(end.getTime());
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public void setCalendar(DSAIdentifier calendarIdentifier) {
        this.calendarIdentifier = calendarIdentifier;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
