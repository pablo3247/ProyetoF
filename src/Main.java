
import CrearTablas.CrearTareas;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    final JPanel panel = new JPanel();

    final JButton boton1 = new JButton("Ver Tareas");

    final JButton boton2 = new JButton("Crear Tareas");

    final JButton boton3 = new JButton("Eliminar Tareas");

    final JButton boton4 = new JButton("Ver trabajadores");


    public Main() {

        panel.add(boton1);

        panel.add(boton2);

        panel.add(boton3);

        panel.add(boton4);
        setContentPane(panel);

        setSize(500, 250);

        setTitle("GESTOR DE TAREAS DE PABLO");



        setVisible(true);

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaTareas ventanaTareas = new VentanaTareas();

               ventanaTareas.setVisible(true);
            }
        });


    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override

            public void run() {

                new Main();

            }

        });

    }

}

