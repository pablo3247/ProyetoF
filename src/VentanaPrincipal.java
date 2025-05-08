
import CrearTablas.CrearTareas;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {

    final JPanel panel = new JPanel();

    final JButton boton1 = new JButton("Ver Tareas");

    final JButton boton2 = new JButton("Crear Tareas");

    final JButton boton3 = new JButton("Eliminar Tareas");

    final JButton boton4 = new JButton("Ver trabajadores");

    final JButton boton5 = new JButton("Asignar Tareas");


    public VentanaPrincipal() {

        panel.add(boton1);

        panel.add(boton2);

        panel.add(boton3);

        panel.add(boton4);

        panel.add(boton5);
        setContentPane(panel);

        setSize(500, 250);

        setTitle("GESTOR DE TAREAS DE PABLO");



        setVisible(true);

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaCrearTareas VentanaCrearTareas = new VentanaCrearTareas();

                VentanaCrearTareas.setVisible(true);
            }
        });

        boton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaCrearTareas VentanaCrearTareas = new VentanaCrearTareas();

                VentanaCrearTareas.setVisible(true);
            }
        });



    }

    public static void VentanaPrincipal(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override

            public void run() {

                new VentanaPrincipal();

            }

        });

    }

}

