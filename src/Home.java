import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    private JPanel mainPanel;
    private JRadioButton penyakitMataRadioButton;
    private JRadioButton penyakitMentalRadioButton;
    private JLabel pilihJenisPenyakitJLabel;
    private JButton nextButton;

    public Home() {
        super("Menu Biaya Berobat");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

        penyakitMataRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (penyakitMataRadioButton.isSelected()) {
                    penyakitMentalRadioButton.setSelected(false);
                }
            }
        });

        penyakitMentalRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (penyakitMentalRadioButton.isSelected()) {
                    penyakitMataRadioButton.setSelected(false);
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (penyakitMataRadioButton.isSelected()) {
                    PenyakitMata pm = new PenyakitMata();
                    pm.setVisible(true);
                    dispose();

                } else if (penyakitMentalRadioButton.isSelected()) {
                    PenyakitMental pm = new PenyakitMental();
                    pm.setVisible(true);
                    dispose();
                }

                else {
                    // penerapan exception
                    try {
                        throw new Exception("Pilih salah satu jenis penyakit!");
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, exception.getMessage());
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        // penerapan multi-threading
        EventQueue.invokeLater(new Runnable() {
            public void run () {
                try {
                    Home frame = new Home();
                    frame.setVisible(true);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
