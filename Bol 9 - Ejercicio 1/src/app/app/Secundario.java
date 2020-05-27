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
    ColorUIResource colors[] = { new ColorUIResource(Color.GREEN), new ColorUIResource(Color.RED),
            new ColorUIResource(Color.WHITE), new ColorUIResource(Color.BLUE) };
    String[] c = { "Verde", "Rojo", "Blanco", "Azul" };

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

        cmb = new JComboBox<String>(c);
        cmb.setSize(100, 100);
        cmb.setLocation(200, 500);
        cmb.addItemListener(this);
        this.add(cmb);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        f.setTitle(txtTitulo.getText());
        f.setTitulo(txtTitulo.getText());
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        f.setColor(colors[cmb.getSelectedIndex()]);
    }
}
