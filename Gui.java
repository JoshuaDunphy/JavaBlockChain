import javax.swing.*;
import java.awt.*;


public class Gui {

    public Gui() {
        JFrame frame = new JFrame("Java BlockChain");
        JPanel panel = new JPanel();
        JButton mineButton = new JButton("Mine");
        JLabel mineLabel = new JLabel("Press to mine a block.");
        JButton createBlockButton = new JButton("Create Block");
        JLabel createBlockLabel = new JLabel("Fill in the required fields to create a block");
       
       
        // Main panel config
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    

        // sub-panel-1 config
        JPanel minePanel = new JPanel();
        minePanel.setLayout(new BoxLayout(minePanel, BoxLayout.Y_AXIS));

        mineButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        mineButton.setPreferredSize(new Dimension(60,20));
        minePanel.add(mineLabel);
        minePanel.add(Box.createVerticalStrut(5)); 
        minePanel.add(mineButton);



        // Sub-panel 2 config
        JPanel createBlockPanel = new JPanel();
        createBlockPanel.setLayout(new BoxLayout(createBlockPanel, BoxLayout.Y_AXIS));
        createBlockLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        createBlockButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        createBlockButton.setPreferredSize(new Dimension(100, 20)); 
        createBlockPanel.add(createBlockLabel);
        createBlockPanel.add(Box.createVerticalStrut(5)); 
        createBlockPanel.add(createBlockButton);


        
        // Sub-panel 3 config 
        JPanel rowPanel = new JPanel();
        rowPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0)); 
        rowPanel.add(minePanel);
        rowPanel.add(createBlockPanel);


        panel.add(rowPanel);


        // frame config
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("JavaBlockchain");
        frame.setSize(400, 600);
        frame.setVisible(true);
    }

}
