package net.maxwellclass.online.xdclass.type;

public enum IsPay {

    YES(1),NO(0);

    private int state;

    public int getState() {
        return state;
    }

    IsPay(int state) {
        this.state = state;
    }
}
