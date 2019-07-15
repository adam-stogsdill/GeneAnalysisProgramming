package bin.main.ThreadManagement;

import bin.main.GUI.Window;

import java.util.Timer;

public class ThreadManager {
    Timer t = new Timer();

    public ThreadManager(Window window) {
        t.scheduleAtFixedRate(new Window_GUI_Thread(window), 0, 5000);

    }
}
