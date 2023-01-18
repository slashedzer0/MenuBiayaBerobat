import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PenyakitMental extends Home {
    private JPanel penyakitMentalPanel;
    private JLabel pilihJenisPenyakitJLabel;
    private JButton nextButton;
    private JButton backButton;
    private JRadioButton OCDRadioButton;
    private JRadioButton depresiRadioButton;
    private JRadioButton bipolarRadioButton;

    public PenyakitMental() {
        setContentPane(penyakitMentalPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
        setLocationRelativeTo(null);

        // array enyakit mental
        String [] daftarPenyakitMental = {
                "Bipolar",
                "Depresi",
                "OCD"
        };

        String[] biayaPenyakitMental = {
                "Rp. 2.253.000",
                "Rp. 4.190.000",
                "Rp. 2.909.000"
        };

        bipolarRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bipolarRadioButton.isSelected()) {
                    OCDRadioButton.setSelected(false);
                    depresiRadioButton.setSelected(false);
                }
            }
        });

        OCDRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (OCDRadioButton.isSelected()) {
                    bipolarRadioButton.setSelected(false);
                    depresiRadioButton.setSelected(false);
                }
            }
        });

        depresiRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (depresiRadioButton.isSelected()) {
                    bipolarRadioButton.setSelected(false);
                    OCDRadioButton.setSelected(false);
                }
            }
        });

        // penerapan polymorphism
        class backToHome extends Home {
            @Override
            public void setVisible(boolean visible) {
                super.setVisible(visible);
            }
        }

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home hm = new backToHome();
                hm.setVisible(true);
                dispose();
            }
        });

        // menampilkan biaya berobat penyakit mental
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bipolarRadioButton.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Biaya berobat " + daftarPenyakitMental[0] + ": " + biayaPenyakitMental[0]);
                } else if (depresiRadioButton.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Biaya berobat " + daftarPenyakitMental[1] + ": " + biayaPenyakitMental[1]);
                } else if (OCDRadioButton.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Biaya berobat " + daftarPenyakitMental[2] + ": " + biayaPenyakitMental[2]);
                } else {
                    // penerapan exception
                    try {
                        throw new Exception("Pilih salah satu!");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });
    }
}
