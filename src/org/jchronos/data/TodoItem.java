/*
 */

package org.jchronos.data;

import java.util.Date;

/**
 *
 * @author ranjith
 */
public class TodoItem {
   

    private String subject;
    private Date dueBy;
    private Date startBy;
    private Priority priority;
    private String category;
    private Status status;
    private String notes;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDueBy() {
        return dueBy;
    }

    public void setDueBy(Date dueBy) {
        this.dueBy = dueBy;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Date getStartBy() {
        return startBy;
    }

    public void setStartBy(Date startBy) {
        this.startBy = startBy;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
