import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.SimpleDateFormat;
import java.util.Date;


public class VentanaCrearTareas extends JFrame {

    private String nameTarea;
    private String Descrip;
    private String FechaFinal;
    private String TrabajadoresAsignados;



    public VentanaCrearTareas() {
        setTitle("Crear Nueva Tarea");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(0,1,5,5));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        panel.add(new JLabel("Nombre de la tarea:"));
        JTextField txtNameTarea = new JTextField(20);
        panel.add(txtNameTarea);

        JLabel LabDescrip = new JLabel("Descripcion: ");
        JTextField txtDescrip = new JTextField(20);
        panel.add(LabDescrip);
        panel.add(txtDescrip);

        JLabel LabTrabajadores = new JLabel("Trabajadores Asignados: ");
        JTextField txtTrabajadores = new JTextField(20);
        panel.add(LabTrabajadores);
        txtTrabajadores.setText("Ejemplo: Juan Pérez, María García, Carlos López");
        txtTrabajadores.setForeground(Color.GRAY); // Color para el placeholder

        // Comportamiento del placeholder
        txtTrabajadores.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTrabajadores.getText().equals("Ejemplo: Juan Pérez, María García, Carlos López")) {
                    txtTrabajadores.setText("");
                    txtTrabajadores.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtTrabajadores.getText().isEmpty()) {
                    txtTrabajadores.setForeground(Color.GRAY);
                    txtTrabajadores.setText("Ejemplo: Juan Pérez, María García, Carlos López");
                }
            }
        });

        panel.add(txtTrabajadores);


        panel.add(new JLabel("Fecha Límite:"));
        JSpinner spinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");

        spinner.setEditor(editor);
        panel.add(spinner);








        JButton botonGuardar = new JButton("Guardar");
        botonGuardar.addActionListener(e -> {

            if(txtNameTarea.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtTrabajadores.equals("Ejemplo: Juan Pérez, María García, Carlos López") || txtTrabajadores.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe asignar al menos un trabajador", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }


            nameTarea = txtNameTarea.getText();
            Descrip = txtDescrip.getText();
            Date fecha = (Date) spinner.getValue();
            TrabajadoresAsignados = txtTrabajadores.getText();
            FechaFinal = new SimpleDateFormat("dd/MM/yyyy").format(fecha);


            Tareas.addTarea(nameTarea,Descrip,FechaFinal);


            System.out.println(nameTarea+Descrip+TrabajadoresAsignados+FechaFinal);


            JOptionPane.showMessageDialog(this, "Tarea guardada: " + txtNameTarea.getText());
        });
        panel.add(botonGuardar);

        add(panel);
    }




}