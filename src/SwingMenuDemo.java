import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingMenuDemo implements ActionListener {
   private JFrame mainFrame;
   private JLabel statusLabel;
   private JCheckBoxMenuItem toggleMenuItem;

   public SwingMenuDemo() {
      mainFrame = new JFrame("Swing Menu Demo");
      mainFrame.setSize(400, 300);
      mainFrame.setLayout(new FlowLayout());
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JMenuBar menuBar = new JMenuBar();

      JMenu fileMenu = new JMenu("File");
      JMenuItem newMenuItem = new JMenuItem("New");
      newMenuItem.addActionListener(this);
      fileMenu.add(newMenuItem);

      JMenuItem openMenuItem = new JMenuItem("Open");
      openMenuItem.addActionListener(this);
      fileMenu.add(openMenuItem);

      JMenuItem saveMenuItem = new JMenuItem("Save");
      saveMenuItem.addActionListener(this);
      fileMenu.add(saveMenuItem);

      toggleMenuItem = new JCheckBoxMenuItem("Toggle Edit Menu");
      toggleMenuItem.addActionListener(this);
      fileMenu.add(toggleMenuItem);

      JMenu editMenu = new JMenu("Edit");
      JMenuItem cutMenuItem = new JMenuItem("Cut");
      cutMenuItem.addActionListener(this);
      editMenu.add(cutMenuItem);

      JMenuItem copyMenuItem = new JMenuItem("Copy");
      copyMenuItem.addActionListener(this);
      editMenu.add(copyMenuItem);

      JMenuItem pasteMenuItem = new JMenuItem("Paste");
      pasteMenuItem.addActionListener(this);
      editMenu.add(pasteMenuItem);

      menuBar.add(fileMenu);
      menuBar.add(editMenu);

      statusLabel = new JLabel("Status:");

      mainFrame.setJMenuBar(menuBar);
      mainFrame.add(statusLabel);

      mainFrame.setVisible(true);
   }

   public static void main(String[] args) {
      new SwingMenuDemo();
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == toggleMenuItem) {
         JMenu editMenu = ((JMenuBar) mainFrame.getJMenuBar()).getMenu(1); // Assuming Edit menu is the second menu
         editMenu.setVisible(toggleMenuItem.isSelected());
      } else {
         statusLabel.setText(e.getActionCommand() + " JMenuItem clicked.");
      }
   }
}