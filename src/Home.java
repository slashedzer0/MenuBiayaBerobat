import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    private JPanel mainPanel;
    private JLabel pilihJenisPenyakitJLabel;
    private JButton mataButton;
    private JButton mentalButton;

    public Home() {
        super("Menu Biaya Berobat");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 275);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

        // eksekusi tombol mata
        mataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PenyakitMata pma = new PenyakitMata();
                pma.setVisible(true);
                dispose();
            }
        });

        // eksekusi tombol mental
        mentalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PenyakitMental pme = new PenyakitMental();
                pme.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        // penerapan multi-threading dan exception handling
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
