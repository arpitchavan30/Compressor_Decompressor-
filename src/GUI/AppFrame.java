package GUI;

import CompressorDecompressor.compressor;
import CompressorDecompressor.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;





    AppFrame() {
        setTitle("Compressor_Decompressor");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        // create objects of buttons
        compressButton = new JButton("Select file to compress");
        compressButton.setBounds(50, 50, 200, 30);
        compressButton.addActionListener(this); // call actionListener on pressing button


        decompressButton = new JButton("Select file to decompress");
        decompressButton.setBounds(300, 50, 200, 30);
        decompressButton.addActionListener(this); // call actionListener on pressing button

        JButton close = new JButton("Close");
        close.setBounds(150,100,200,30);


        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(1000, 500);
        this.getContentPane().setBackground(Color.CYAN);



        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // on pressing compress button
        if (e.getSource() == compressButton) {
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                //System.out.println(file);
                try{
                    compressor.method(file);
                }
                catch(Exception excep){
                    JOptionPane.showMessageDialog(null,excep.toString());
                }
            }
        }

        if (e.getSource() == decompressButton) {
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    decompressor.method(file);
                }
                catch(Exception excep){
                    JOptionPane.showMessageDialog(null,excep.toString());
                }
            }

        }

    }
}

