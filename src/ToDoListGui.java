import javax.swing.*;

public class ToDoListGui extends JFrame {
    public ToDoListGui(){
        super("To Do List app");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(CommonConstants.GUI_SIZE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
    }

}
