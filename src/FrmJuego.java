import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;


/**
 *
 * @author David y Andres
 */
public class FrmJuego extends javax.swing.JFrame {

    int numFilas=10;
    int numColumnas=10; 
    int numMinas=20;
    JButton[][] botonesTablero;
   
    
     
    public FrmJuego() {
        initComponents();
    }
    
    private void CargarControles(){
        
        int posXReferncia=25;
        int posYReferencia=25;
        int anchoControl=30;
        int altoControl=30;
        
        
        botonesTablero = new JButton[numFilas][numColumnas];
        for (int i=0; i< botonesTablero.length; i++) {
            for (int j = 0; j< botonesTablero[i].length; j++){
                botonesTablero[i][j]=new JButton ();
                botonesTablero[i][j].setName(i+","+j);
                botonesTablero[i][j].setBorder(null);    
                if (i==0 && j==0){
                    botonesTablero[i][j].setBounds(posXReferncia,
                           posYReferencia, anchoControl, altoControl);
                }else if (i==0 && j!=0) {
                    botonesTablero[i][j].setBounds(
                           botonesTablero[i][j-1].getX()+botonesTablero[i][j-1].getWidth(),
                           posYReferencia, anchoControl, altoControl);    
                }else{
                    botonesTablero[i][j].setBounds(
                           botonesTablero[i-1][j].getX(),
                           botonesTablero[i-1][j].getY()+botonesTablero[i-1][j].getHeight(),
                           anchoControl, altoControl);
                }   
                getContentPane().remove(botonesTablero[i][j]);
                
               botonesTablero[i][j].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnClick(e);
                    }
                });
                getContentPane().add(botonesTablero[i][j]);
                
                        
            }   
        }
    }
    private void  btnClick(ActionEvent e) {
        JButton btn=(JButton)e.getSource();
        String[]coordenada=btn.getName().split(",");
        int posFila=Integer.parseInt(coordenada[0]);
        int posColumna=Integer.parseInt(coordenada[1]);
        JOptionPane.showMessageDialog(rootPane, posFila+","+posColumna);
    }
    //esto aparecio automatico al rear el formulario
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
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
            java.util.logging.Logger.getLogger(FrmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
