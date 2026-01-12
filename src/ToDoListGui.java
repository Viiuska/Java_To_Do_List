import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListGui extends JFrame implements ActionListener {

    private JPanel taskPanel, taskComponentPanel;

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
        bannerLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));
        bannerLabel.setBounds(
                (CommonConstants.GUI_SIZE.width - bannerLabel.getPreferredSize().width)/2,
                15, CommonConstants.BANNER_SIZE.width, CommonConstants.BANNER_SIZE.height
        );

        taskPanel = new JPanel();

        taskComponentPanel = new JPanel();
        taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel, BoxLayout.Y_AXIS));
        taskPanel.add(taskComponentPanel);

        JScrollPane scrollPane = new JScrollPane(taskPanel);
        scrollPane.setBounds(8, 70, CommonConstants.TASKPANEL_SIZE.width, CommonConstants.TASKPANEL_SIZE.height);
        scrollPane.setBorder(BorderFactory.createLoweredBevelBorder());
        scrollPane.setMaximumSize(CommonConstants.TASKPANEL_SIZE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //Scroll bar speed
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(20);

        JButton addTaskButton = new JButton("Add Task");
        addTaskButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        addTaskButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addTaskButton.setBounds(-5, CommonConstants.GUI_SIZE.height -88,
                CommonConstants.ADDTASKBUTTON_SIZE.width, CommonConstants.ADDTASKBUTTON_SIZE.height);
        addTaskButton.addActionListener(this);


        this.getContentPane().add(bannerLabel);
        this.getContentPane().add(scrollPane);
        this.getContentPane().add(addTaskButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equalsIgnoreCase("Add Task")) {
           TaskComponents taskComponents = new TaskComponents(taskComponentPanel);
           taskComponentPanel.add(taskComponents);

           if(taskComponentPanel.getComponentCount() > 1){
               TaskComponents previousTask = (TaskComponents) taskComponentPanel.getComponent(taskComponentPanel.getComponentCount() - 2);
               previousTask.getTaskField().setBackground(null);
           }

           taskComponents.getTaskField().requestFocus();
           repaint();
           revalidate();

        }
    }

}
