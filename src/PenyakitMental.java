import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PenyakitMental extends Home {
    private JPanel penyakitMentalPanel;
    private JLabel pilihJenisPenyakitJLabel;
    private JButton kembaliButton;
    private JButton OCDButton;
    private JButton depresiButton;
    private JButton bipolarButton;

    public PenyakitMental() {
        setContentPane(penyakitMentalPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(625, 275);
        setVisible(true);
        setLocationRelativeTo(null);

        // array penyakit mental
        String [] daftarPenyakitMental = {
                "Bipolar",
                "OCD",
                "Depresi"
        };

        String[] biayaPenyakitMental = {
                "Rp. 2.253.000",
                "Rp. 2.909.000",
                "Rp. 4.190.000"
        };

        // penerapan polymorphism
        class backToHome extends Home {
            @Override
            public void setVisible(boolean visible) {
                super.setVisible(true);
            }
        }

        kembaliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home hm = new backToHome();
                hm.setVisible(true);
                dispose();
            }
        });

        // eksekusi tombol bipolar dengan exception handling
        try {
            bipolarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Biaya pengobatan " + daftarPenyakitMental[0] + ": " + biayaPenyakitMental[0]);
                }
            });
        }
        catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Tidak ada data!");
        }

        // eksekusi tombol OCD dengan exception handling
        try {
            OCDButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Biaya pengobatan " + daftarPenyakitMental[1] + ": " + biayaPenyakitMental[1]);
                }
            });
        }
        catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Tidak ada data!");
        }

        // eksekusi tombol depresi dengan exception handling
        try {
            depresiButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Biaya pengobatan " + daftarPenyakitMental[2] + ": " + biayaPenyakitMental[2]);
                }
            });
        }
        catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Tidak ada data!");
        }
    }
}
