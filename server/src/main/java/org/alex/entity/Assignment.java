package org.alex.entity;

import org.jetbrains.annotations.NotNull;

public class Assignment {

    private String assignmentId;
    private String assigningId;

    public Assignment() {
    }

    public Assignment(@NotNull String assignmentId, @NotNull String assigningId) {
        this.assignmentId = assignmentId;
        this.assigningId = assigningId;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(@NotNull String assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getAssigningId() {
        return assigningId;
    }

    public void setAssigningId(@NotNull String assigningId) {
        this.assigningId = assigningId;
    }

}
