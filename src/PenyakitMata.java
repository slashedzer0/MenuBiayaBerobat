import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PenyakitMata extends Home {
    private JPanel penyakitMataPanel;
    private JLabel pilihJenisPenyakitJLabel;
    private JButton nextButton;
    private JRadioButton rabunRadioButton;
    private JRadioButton katarakRadioButton;
    private JButton backButton;

    public PenyakitMata() {
        setContentPane(penyakitMataPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
        setLocationRelativeTo(null);

        // array penyakit mata
        String[] daftarPenyakitMata = {
                "Katarak",
                "Rabun"
        };

        String[] biayaPenyakitMata = {
                "Rp. 6.970.000",
                "Rp. 3.520.000"
        };

        rabunRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rabunRadioButton.isSelected()) {
                    katarakRadioButton.setSelected(false);
                }
            }
        });

        katarakRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (katarakRadioButton.isSelected()) {
                    rabunRadioButton.setSelected(false);
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

        // menampilkan biaya berobat penyakit mata
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (katarakRadioButton.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Biaya berobat " + daftarPenyakitMata[0] + ": " + biayaPenyakitMata[0]);
                } else if (rabunRadioButton.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Biaya berobat " + daftarPenyakitMata[1] + ": " + biayaPenyakitMata[1]);
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
