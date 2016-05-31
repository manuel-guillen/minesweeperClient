package main;

import javax.swing.UIManager;

import minesweeper.gui.MinesweeperClientFrame;

public class Main {
    
    /**
     * Start a MinesweeperClientFrame UI.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Use default look-and-feel
        }
        MinesweeperClientFrame.startMinesweeperClientFrameUI();
    }
    
}
