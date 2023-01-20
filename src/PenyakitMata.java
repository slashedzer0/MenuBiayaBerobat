import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PenyakitMata extends Home {
    private JPanel penyakitMataPanel;
    private JLabel pilihJenisPenyakitJLabel;
    private JButton katarakButton;
    private JButton rabunButton;
    private JButton kembaliButton;

    public PenyakitMata() {
        setContentPane(penyakitMataPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 275);
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

        // eksekusi tombol katarak dengan exception handling
        try {
            katarakButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Biaya pengobatan " + daftarPenyakitMata[0] + ": " + biayaPenyakitMata[0]);
                }
            });
        }
        catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Tidak ada data!");
        }

        // eksekuksi tombol rabun dengan exception handling
        try {
            rabunButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Biaya pengobatan " + daftarPenyakitMata[1] + ": " + biayaPenyakitMata[1]);
                }
            });
        }
        catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Tidak ada data!");
        }
    }
}
