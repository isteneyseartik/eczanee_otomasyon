package eczanee_otomasyon;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.Timer;
public class giris_ekrani extends javax.swing.JFrame{
String url="jdbc:mysql://localhost:3306/";
String veritabaniadi="eczanee";
String surucu="com.mysql.jdbc.Driver";
String kullaniciAdi="root";
String kullaniciParolası="Sezer1923_";
java.sql.Connection baglanti=null;
java.sql.Statement komut=null;
ResultSet gelenveri=null; 
PreparedStatement pst=null;

    public giris_ekrani() {
        initComponents();
    
       
        jLabel1.setText("HOŞEGLDİNİZ"); 
        try {
        Class.forName(surucu);
        //Baglantı veri tabanı seçimi kullanıcı adı ve parola ile sağlanıyor
        baglanti= DriverManager.getConnection(url+veritabaniadi, kullaniciAdi,kullaniciParolası);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.toString());
        
        }
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        giris_button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_kullanici = new javax.swing.JTextField();
        password_txt = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        password_check = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(500, 500));
        setPreferredSize(new java.awt.Dimension(790, 620));
        setSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 100, 510, 90);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        jLabel2.setText("Kullanıcı Adı:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(360, 270, 160, 30);

        giris_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        giris_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login.png"))); // NOI18N
        giris_button.setText("Giriş");
        giris_button.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        giris_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giris_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(giris_button);
        giris_button.setBounds(590, 450, 130, 40);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/şifre.png"))); // NOI18N
        jLabel3.setText("Şifre:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(360, 360, 160, 30);

        txt_kullanici.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txt_kullanici);
        txt_kullanici.setBounds(520, 270, 180, 30);

        password_txt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(password_txt);
        password_txt.setBounds(520, 360, 180, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/house.png"))); // NOI18N
        jButton1.setText("Anasayfa");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(450, 450, 130, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/image.jpg"))); // NOI18N
        jLabel4.setText("sezeer test");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(-50, -40, 900, 640);

        password_check.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        password_check.setForeground(new java.awt.Color(255, 153, 0));
        password_check.setText("Şifreyi Göster");
        password_check.setContentAreaFilled(false);
        password_check.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        password_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_checkActionPerformed(evt);
            }
        });
        getContentPane().add(password_check);
        password_check.setBounds(590, 400, 110, 23);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(100, 210, 0, 2);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void giris_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_giris_buttonActionPerformed
       String sorgu = "SELECT * FROM eczanee.uyelikler where kullanici_adi=? and password=?;";
        try {
            pst=baglanti.prepareStatement(sorgu);
            pst.setString(1, txt_kullanici.getText());
            pst.setString(2, password_txt.getText());
            gelenveri=pst.executeQuery();
            if(gelenveri.next()){
                JOptionPane.showMessageDialog(null,"Giriş Başarılı");
                 yonetici_giris_paneli git= new yonetici_giris_paneli();
                 git.setVisible(true);
                 hide();
            }
            else{
            JOptionPane.showMessageDialog(null,"Kullanıcı Adı veya Şifre Hatalı");
            }
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Sorguda hata var ");
        }
      
    }//GEN-LAST:event_giris_buttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       ilk_giris git=new ilk_giris();
       git.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void password_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_checkActionPerformed
        if (password_check.isSelected()){
            password_txt.setEchoChar((char)0);
        }
        else {
            password_txt.setEchoChar('*');
        }
    }//GEN-LAST:event_password_checkActionPerformed
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(giris_ekrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(giris_ekrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(giris_ekrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(giris_ekrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new giris_ekrani().setVisible(true);
            }
        });
    }
    private Timer timer;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton giris_button;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox password_check;
    private javax.swing.JPasswordField password_txt;
    private javax.swing.JTextField txt_kullanici;
    // End of variables declaration//GEN-END:variables
}
