package kata6;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import kata6.control.Command;
import kata6.control.DownCommand;
import kata6.control.LeftCommand;
import kata6.control.RightCommand;

import kata6.control.UpCommand;
import kata6.model.Block;


public class Main extends JFrame{
    
    public static void main(String[] args) {
        new Main().execute();
        
    }
    private BlockPanel blockDisplay;
    private Map<String,Command> commands = new HashMap<>();
    
    public Main(){
        this.setTitle("Block shifter");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700,762);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(blockPanel());
        this.add(toolbar(),BorderLayout.SOUTH);
        
        Block block = new Block(4, 4);
        this.blockDisplay.display(block);
        this.commands.put("left", new LeftCommand(block));
        this.commands.put("right", new RightCommand(block));
        this.commands.put("up", new UpCommand(block));
        this.commands.put("down", new DownCommand(block));
    }
    
    private void execute()
    {

        this.setVisible(true);
        
    }
    
    private JPanel blockPanel()
    {
        BlockPanel panel = new BlockPanel();
        this.blockDisplay = panel;
        return panel;
    }

    private JMenuBar toolbar() {
        JMenuBar menubar = new JMenuBar();
        menubar.add(button("left"));
        menubar.add(button("right"));
        menubar.add(button("up"));
        menubar.add(button("down"));
        return menubar;
    }

    private JButton button(String name) {
        JButton button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                commands.get(name).execute();
                
            }
        });
        return button;
    }

   
    
}
