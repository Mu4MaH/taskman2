package org.alex.enumerated;

public enum State {
    OPEN(1),
    SET(2),
    INWORK(3),
    FINISHED(4),
    CLOSED(5);

    private final int index;

    State(int index) {
        this.index = index;
    }

//    public State setById(int index) {
//        for (State s : State.values()) {
//            if (s.index == index)
//                return s;
//        }
//        return State.OPEN;
//    }
//
//    public int getIndex() {
//        return index;
//    }
}
