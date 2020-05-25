package app;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class Secundario extends JDialog implements ActionListener, ItemListener {

    private JLabel lblTitulo;
    private JLabel lblColor;
    private JTextField txtTitulo;
    private JComboBox<String> cmb;
    Principal f = (Principal) this.getOwner();
    String[] colors = { "Verde", "Rojo", "Blanco", "Azul" };

    public Secundario(Principal f) {

        super(f, true);
        setLayout(new FlowLayout());

        setTitle("Selección de título y color");

        lblTitulo = new JLabel("Introduce un nuevo título estándar para el formulario principal");
        add(lblTitulo);

        txtTitulo = new JTextField(10);
        txtTitulo.addActionListener(this);
        add(txtTitulo);

        lblColor = new JLabel("Selecciona el color para los botones:");
        add(lblColor);

        cmb = new JComboBox<String>(colors);
        cmb.setSize(100, 100);
        cmb.setLocation(200, 500);
        cmb.setMaximumRowCount(8);
        cmb.setSelectedIndex(3);
        cmb.addItemListener(this);
        this.add(cmb);

    }

    public ColorUIResource chooseColor(String s) {

        ColorUIResource color = new ColorUIResource(Color.BLUE);

        switch (s) {
            case "Verde":
                color = new ColorUIResource(Color.GREEN);
                break;

            case "Rojo":
                color = new ColorUIResource(Color.RED);
                break;

            case "Blanco":
                color = new ColorUIResource(Color.WHITE);
                break;

            case "Azul":
                color = new ColorUIResource(Color.BLUE);
                break;

        }
        return color;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        f.setTitle(txtTitulo.getText());
        f.setTitulo(txtTitulo.getText());
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        f.setColor(chooseColor(cmb.getSelectedItem().toString()));
    }
}
