package bin.main.ThreadManagement;

import bin.main.GUI.Window;

import java.util.TimerTask;

public class Window_GUI_Thread extends TimerTask {

    Window window;


    public Window_GUI_Thread(Window w) {
        this.window = w;
    }

    public void run() {
        //window.repaint();
    }
}
