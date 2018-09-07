package studio.rashka.Lib;

import studio.rashka.History;

public class Monitor { // для portrait ориентации

    private float ratioMonitorW = 0, ratioMonitorH = 0;
    private static int mWIDTH = History.WIDTH, mHEIGHT = History.HEIGHT;

    public Monitor () {
        onWidth();
        onHeight();
        if (ratioMonitorW != ratioMonitorH) {
            History.setWIDTH(1200);
            mWIDTH = History.WIDTH;
            ratioMonitorW = 0;
            ratioMonitorH = 0;
            onWidth();
            onHeight();
        }
    }

    private void onWidth() {
        if (History.getPreference().width() == 0) ratioMonitorW = (float) (History.WIDTH / 3) / (float) mWIDTH;
        else ratioMonitorW = (float) History.getPreference().width() / (float) mWIDTH;
    }

    private void onHeight() {
        if (History.getPreference().height() == 0) ratioMonitorH = (float) (History.HEIGHT / 3) / (float) mHEIGHT;
        else ratioMonitorH = (float) History.getPreference().height() / (float) mHEIGHT;
    }

    public float getRatioMonitorW() {
        return ratioMonitorW;
    }

    public float getRatioMonitorH() {
        return ratioMonitorH;
    }
}