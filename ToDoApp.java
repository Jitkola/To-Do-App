import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class ToDoApp extends JFrame implements ActionListener{

    JLabel label1;
    JTextField F1;
    JButton b1, b2, b3;
    DefaultListModel<String> taskListModel;
    JList<String> tasklist;
    JScrollPane scroll;

    public ToDoApp(){
        super("To-Do List Application");

        setLayout(null);

        //creating label
        label1 = new JLabel("My To-Do List");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 25));
        label1.setBounds(180, 30, 240, 40);
        add(label1);

        //adding a textfield 
        F1 = new JTextField(20);
        F1.setFont(new Font("Arial", Font.PLAIN, 25));
        F1.setBounds(50, 120, 250, 35);
        add(F1);

        //creating button for textfield
        b1 = new JButton("Add Task");
        b1.setFont(new Font("Arial", Font.BOLD, 20));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(350, 120, 125, 35);
        b1.addActionListener(this);
        add(b1);

        //creating delete button
        b2 = new JButton("Delete Selected");
        b2.setFont(new Font("Arial", Font.BOLD, 20));
        b2.setForeground(Color.white);
        b2.setBackground(Color.BLACK);
        b2.setBounds(50, 190, 250, 35);
        b2.addActionListener(this);
        add(b2);

        //creating clear all button
        b3 = new JButton("Clear All");
        b3.setFont(new Font("Arial", Font.BOLD, 20));
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.setBounds(350, 190, 125, 35);
        b3.addActionListener(this);
        add(b3);

        //Task
        taskListModel = new DefaultListModel<>();
        tasklist = new JList<>(taskListModel);
        tasklist.setFont(new Font("Arial", Font.PLAIN, 25));
        tasklist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //creating scroll
        scroll = new JScrollPane(tasklist);
        scroll.setBounds(50, 270, 425, 220);
        add(scroll);

        //creating frame
        setSize(560, 600);
        setLocation(900, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(30,30,30));
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent E){
        try {
            if(E.getSource() == b1){
                String task = F1.getText().trim();
                if(task.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter a task");
                    return;
                }
                taskListModel.addElement(task);
                F1.setText("");
            }
            else if (E.getSource() == b2) {
                int selected = tasklist.getSelectedIndex();
                if (selected != -1) {
                    taskListModel.remove(selected);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a task to delete!");
                }
            }
            else if (E.getSource() == b3) {
                if (taskListModel.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No tasks to clear!");
                } else {
                    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear all tasks ?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        taskListModel.clear();
                    }
                }
            } 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ToDoApp();
    }   

}