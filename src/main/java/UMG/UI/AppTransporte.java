
package UMG.UI;

import UMG.DAO.conexionDB;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AppTransporte {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> crearVentana());
    }

    private static void crearVentana() {
        JFrame ventana = new JFrame("Sistema de Transporte");
        ventana.setSize(550, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        JLabel titulo = new JLabel(
                "SISTEMA DE GESTIÓN DE TRANSPORTE",
                SwingConstants.CENTER
        );
        titulo.setFont(new Font("Arial", Font.BOLD, 18));

        JButton btnConexion = new JButton("Probar conexión con MySQL");
        JButton btnCamiones = new JButton("Gestión de camiones");
        JButton btnCamioneros = new JButton("Gestión de camioneros");
        JButton btnPaquetes = new JButton("Gestión de paquetes");
        JButton btnAsignaciones = new JButton("Asignación de camiones");

        btnConexion.addActionListener(e -> {
            try (Connection conexion = conexionDB.abrir()) {
                JOptionPane.showMessageDialog(
                        ventana,
                        "Conexión con db_paqueteria exitosa."
                );
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(
                        ventana,
                        "Error de conexión:\n" + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        btnCamiones.addActionListener(e ->
                new FMCamion().setVisible(true));

        btnCamioneros.addActionListener(e ->
                new FMCamionero().setVisible(true));

        btnPaquetes.addActionListener(e ->
                new FMPaquete().setVisible(true));

        btnAsignaciones.addActionListener(e -> {
            JFrame ventanaAsignaciones = new JFrame("Asignación de Camiones");
            ventanaAsignaciones.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventanaAsignaciones.setContentPane(new FMCamioneroCamion());
            ventanaAsignaciones.pack();
            ventanaAsignaciones.setLocationRelativeTo(ventana);
            ventanaAsignaciones.setVisible(true);
        });

        JPanel botones = new JPanel(new GridLayout(5, 1, 10, 10));
        botones.add(btnConexion);
        botones.add(btnCamiones);
        botones.add(btnCamioneros);
        botones.add(btnPaquetes);
        botones.add(btnAsignaciones);

        JPanel panel = new JPanel(new BorderLayout(10, 20));
        panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(titulo, BorderLayout.NORTH);
        panel.add(botones, BorderLayout.CENTER);

        ventana.add(panel);
        ventana.setVisible(true);
    }
}
