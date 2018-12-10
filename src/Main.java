import gu_interface.WindowApp;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WindowApp windowApp = new WindowApp();
            }
        });
    }

}
