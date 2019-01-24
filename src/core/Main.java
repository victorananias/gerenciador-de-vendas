
package core;

import views.Login;

public class Main {
    public static void main(String args[]) {
        CrunchifyGetPropertyValues properties = new CrunchifyGetPropertyValues();
        new Login().setVisible(true);
    }
}
