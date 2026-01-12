import javax.swing.*;

public class TaskComponents extends JPanel {
    private JCheckBox checkBox;
    private JTextPane taskField;
    private JButton deleteButton;

    public JTextPane getTaskField() {
        return taskField;
    }

    private JPanel parentPanel;

    public TaskComponents(JPanel parentPanel){
        this.parentPanel = parentPanel;

        taskField = new JTextPane();
        taskField.setPreferredSize(CommonConstants.TASKFIELD_SIZE);
        taskField.setContentType("text/html");

        checkBox = new JCheckBox();
        checkBox.setPreferredSize(CommonConstants.CHECKBOX_SIZE);

        deleteButton = new JButton("X");
        deleteButton.setPreferredSize(CommonConstants.DELETEBUTTON_SIZE);


        add(taskField);
        add(checkBox);
        add(deleteButton);

    }


}
