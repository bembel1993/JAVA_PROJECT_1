package Messenger.Control;

import java.io.IOException;

public interface Control {

    void demoCaseMenuInfo(int push) throws IOException, ClassNotFoundException;

    void showMenu();

    boolean isValid(int ch);

}
