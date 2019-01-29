package org.alex.enumerated;

public enum Priority {
    IDLE(1),
    NORMAL(2),
    URGENT(3),
    FATAL(4);

    public final int index;

    Priority(int index) {
        this.index = index;
    }

//    public int getIndex() {
//        return this.index;
//    }

//    public Priority setById(int index) {
//        for (Priority p : Priority.values()) {
//            if (p.index == index)
//                return p;
//        }
//        return Priority.IDLE; // if index is invalid
//    }
}
