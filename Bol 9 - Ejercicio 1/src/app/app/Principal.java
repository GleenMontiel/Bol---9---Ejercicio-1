package app;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class Principal extends JFrame implements KeyListener {

    private JLabel lbl;
    private JButton btn1;
    private JButton btn2;
    private ColorUIResource color;
    private String titulo;

    public Principal() {

        super("Control de Ratón");
        this.setLayout(null);
        this.setFocusable(true);

        MouseHandler mh = new MouseHandler();
        color = new ColorUIResource(Color.GREEN);
        titulo = "Control de Ratón";

        lbl = new JLabel("Teclas");
        lbl.setSize(2500, 50);
        lbl.setLocation(15, 15);
        this.add(lbl);

        btn1 = new JButton("Botón 1");
        btn1.setSize(100, btn1.getPreferredSize().height);
        btn1.setLocation(45, 80);
        btn1.addMouseListener(mh);
        btn1.addMouseMotionListener(mh);
        this.add(btn1);

        btn2 = new JButton("Botón 2");
        btn2.setSize(100, btn2.getPreferredSize().height);
        btn2.setLocation(150, 80);
        btn2.addMouseListener(mh);
        btn2.addMouseMotionListener(mh);
        this.add(btn2);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "¿Deseas cerrar el programa?", "Bol 9 - Ejercicio 1",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (res == JOptionPane.OK_OPTION)
                    e.getWindow().dispose();
            }
        });

        this.addMouseListener(mh);
        this.addMouseMotionListener(mh);
        addKeyListener(this);

    }

    public ColorUIResource getColor() {
        return color;
    }

    public void setColor(ColorUIResource color) {
        this.color = color;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    private class MouseHandler extends MouseAdapter {

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            setTitle(getTitulo());
        }

        @Override
        public void mouseMoved(java.awt.event.MouseEvent e) {
            if (e.getSource() == btn1 || e.getSource() == btn2) {
                setTitle(String.format("%s – (X:%d, Y:%d)", getTitulo(), e.getX() + e.getComponent().getX(),
                        e.getY() + e.getComponent().getY()));
            } else {
                setTitle(String.format("%s – (X:%d, Y:%d)", getTitulo(), e.getX(), e.getY()));
            }

        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                btn1.setForeground(color);
            }
            if (SwingUtilities.isRightMouseButton(e)) {
                btn2.setForeground(color);
            }
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
            btn1.setForeground(null);
            btn2.setForeground(null);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        lbl.setText(String.format("<html><p>Tecla pulsada: %s</p>\n<p>Unicode: %d</p></html>", e.getKeyChar(),
                e.getKeyCode()));

        if (e.isControlDown() && e.getKeyCode() == 67) {

            Secundario f = new Secundario(this);
            f.pack(); // Tamaño necesario para ver todos los componentes
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setVisible(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //
    }
}