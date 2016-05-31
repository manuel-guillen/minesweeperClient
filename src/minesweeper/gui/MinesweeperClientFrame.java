package minesweeper.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MinesweeperClientFrame extends JFrame implements ActionListener {

    /**
     * Creates a MinesweeperClientFrame.
     */
    public static void startMinesweeperClientFrameUI() {
        new MinesweeperClientFrame();
    }
    
    /**
     * Returns image object for the image file called filename (in media folder).
     * @param filename name of image file (in media folder)
     * @return image object corresponding to the read image file.
     */
    private static BufferedImage getPic(String filename) {
        try {
            return ImageIO.read(MinesweeperClientFrame.class.getResource("/resources/" + filename));
        } catch (IOException e) {
            throw new RuntimeException("Missing " + filename + " file.");
        }
    }

    // =====================================================================================
    
    private static final Font HEADER_FONT = new Font("Tahoma", Font.BOLD, 18);
    private static final Font LABEL_FONT = new Font("Tahoma", Font.PLAIN, 14);
    
    private static final BufferedImage EMPTY = getPic("empty.png");
    private static final BufferedImage MINE = getPic("mine.png");
    private static final BufferedImage UNTOUCHED = getPic("untouched.png");

    private final JTextField addressField, portField;
    private final JButton connectButton;
    
    /**
     * Create the frame.
     */
    private MinesweeperClientFrame() {
        setTitle("Minesweeper Client");
        setBounds(100, 100, 450, 120);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        JLabel headerLabel = new JLabel("Multiplayer Minesweeper Client");
        headerLabel.setBounds(12, 13, 305, 22);
        headerLabel.setFont(HEADER_FONT);
        contentPane.add(headerLabel);
        
        JLabel addressLabel = new JLabel("IP Address:");
        addressLabel.setFont(LABEL_FONT);
        addressLabel.setBounds(12, 50, 74, 16);
        contentPane.add(addressLabel);
        
        JLabel portLabel = new JLabel("Port:");
        portLabel.setFont(LABEL_FONT);
        portLabel.setBounds(221, 50, 36, 16);
        contentPane.add(portLabel);
        
        addressField = new JTextField();
        addressField.setText("127.0.0.1");
        addressField.setBounds(86, 48, 113, 22);
        contentPane.add(addressField);
        
        portField = new JTextField();
        portField.setText("4444");
        portField.setBounds(256, 48, 54, 22);
        contentPane.add(portField);
        
        connectButton = new JButton("Connect");
        connectButton.setBounds(335, 47, 97, 25);
        connectButton.addActionListener(this);
        contentPane.add(connectButton);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
    }
}
