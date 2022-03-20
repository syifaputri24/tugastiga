/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.awt.event.*;
import javax.swing.*;
import Ruang.Balok;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 *
 * @author hp
 */
public class View extends JFrame implements ActionListener {
    JLabel lbljudul = new JLabel("KALKULATOR BALOK");
    
    JLabel lblpanjang = new JLabel("Panjang");
    JTextField tfpanjang = new JTextField(18);
    JLabel lbllebar = new JLabel("Lebar");
    JTextField tflebar = new JTextField(18); 
    JLabel lbltinggi = new JLabel("Tinggi");
    JTextField tftinggi = new JTextField(18);
       
    JLabel lblhasil = new JLabel("Hasil");
    JLabel lblluas = new JLabel();
    JLabel lblkeliling = new JLabel();
    JLabel lblluaspermukaan = new JLabel();
    JLabel lblvolume = new JLabel();
       
    JButton btnhitung = new JButton("Hitung");
    JButton btnreset = new JButton("Reset");

    public View() {
        setTitle("Kalkulator Balok");
           
        setSize(400, 450);
        setLayout(null);
        add(lbljudul);
        add(lblpanjang);
        add(tfpanjang);
        add(lbllebar);
        add(tflebar);
        add(lbltinggi);
        add(tftinggi);
        
        add(lblhasil);
        add(lblluas);
        add(lblkeliling);
        add(lblluaspermukaan);
        add(lblvolume);
        
        add(btnhitung);
        add(btnreset);
        
        //setBounds(int x-coordinate, int y-coordinate, int width, int height)
        lbljudul.setBounds(120,5,140,30);
        lblpanjang.setBounds(20,40,100,20);
        tfpanjang.setBounds(130,40,150,20);
        lbllebar.setBounds(20,65,100,20);
        tflebar.setBounds(130,65,150,20);
        lbltinggi.setBounds(20,95,100,20);
        tftinggi.setBounds(130,95,150,20);
       
        lblhasil.setBounds(145,125,100,30);
        lblluas.setBounds(30,160,200,30);
        lblkeliling.setBounds(30,185,200,30);
        lblluaspermukaan.setBounds(30,210,200,30);
        lblvolume.setBounds(30,235,200,30);
        
        btnhitung.setBounds(70,300,80,20);
        btnreset.setBounds(170,300,80,20);
           
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
       
        btnhitung.addActionListener(this);
        btnreset.addActionListener(this);
       }
       
@Override
    public void actionPerformed(ActionEvent e){
        int panjang, lebar, tinggi;
           
        if (e.getSource() == btnhitung) {
            if (tfpanjang.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Isikan Panjang!");
            } else if (tflebar.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Isikan Lebar!");
            } else if (tftinggi.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Isikan Tinggi!");
            } else {
                try {
                    panjang = Integer.parseInt(tfpanjang.getText());
                    lebar = Integer.parseInt(tflebar.getText());
                    tinggi = Integer.parseInt(tftinggi.getText());
                    
                    Balok balok = new Balok(panjang, lebar, tinggi);
                    
                    lblluas.setText("Luas Persegi Panjang            : " + balok.luas());
                    lblkeliling.setText("Keliling Persegi Panjang       : " + balok.keliling());
                    lblluaspermukaan.setText("Luas Permukaan Balok         : " + balok.luasPermukaan());
                    lblvolume.setText("Volume Balok                           : " + balok.volume());
                } catch(NumberFormatException err){
                    JOptionPane.showMessageDialog(this, "Wajib Mengisikan angka!");
                }
            }
        }
           
        if (e.getSource() == btnreset) {
            lblluas.setText(" ");
            lblkeliling.setText(" ");
            lblluaspermukaan.setText(" ");
            lblvolume.setText(" ");
            tfpanjang.setText("");
            tflebar.setText("");
            tftinggi.setText("");
        }
    }
}