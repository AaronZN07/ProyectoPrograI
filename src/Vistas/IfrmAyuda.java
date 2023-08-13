package Vistas;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author aaron
 */
public class IfrmAyuda extends javax.swing.JInternalFrame {

    String src = "Manual de Usuario_Proyecto Final.pdf";
    
    JButton siguiente;
    JButton anterior;
    
    private PDDocument document;
    private PDFRenderer pdfRenderer;
    private int paginaActual = 0;
    
    public IfrmAyuda() {
        //Se elimina métodoo initComponents ya que provocaba que no se visualizara el PDF
        //Se crean botones manualmente
        this.setTitle("Manual de Ayuda");
        this.setClosable(true);
        
        iniciarPDF();
    }
    
    private void iniciarPDF(){
        try {
            File file = new File(src);
            document = PDDocument.load(file);
            pdfRenderer = new PDFRenderer(document);
        } catch (IOException e) {
            e.printStackTrace();
        }

        desplegarPagina(paginaActual);
        
        pack();
    }
    
    private void desplegarPagina(int numeroPagina) {
        if (numeroPagina >= 0 && numeroPagina < document.getNumberOfPages()) {
            try {
                BufferedImage image = pdfRenderer.renderImage(numeroPagina);
                ImageIcon icon = new ImageIcon(image);
                JLabel label = new JLabel(icon);
                getContentPane().removeAll();
                getContentPane().add(label, BorderLayout.CENTER);
                revalidate();
                repaint();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        iniciarBotones();
    }
    
    private void iniciarBotones(){
        siguiente = new JButton("Siguiente");
        siguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                siguiente();
            }
        });

        anterior = new JButton("Anterior");
        anterior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                anterior();
            }
        });

        JPanel botones = new JPanel();
        botones.add(anterior);
        botones.add(siguiente);

        getContentPane().add(botones, BorderLayout.SOUTH);
    }
    
    private void siguiente() {
        if (paginaActual < document.getNumberOfPages() - 1) {
            paginaActual++;
            desplegarPagina(paginaActual);
        }
    }

    private void anterior() {
        if (paginaActual > 0) {
            paginaActual--;
            desplegarPagina(paginaActual);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setResizable(true);
        setTitle("Manual de Usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 825, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 672, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
