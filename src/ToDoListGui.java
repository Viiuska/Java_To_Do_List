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

        addGuiComponents();
    }

    private void addGuiComponents(){
        JLabel bannerLabel = new JLabel("To Do List");
        bannerLabel.setBounds(
                (CommonConstants.GUI_SIZE.width - bannerLabel.getPreferredSize().width)/2,
                15, CommonConstants.BANNER_SIZE.width, CommonConstants.BANNER_SIZE.height
        );
        this.getContentPane().add(bannerLabel);
    }
}
