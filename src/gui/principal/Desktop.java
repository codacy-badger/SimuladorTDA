package gui.principal;
import tools.Archivos;
import java.awt.*;
import java.util.Objects;
import javax.swing.*;
public final class Desktop extends JFrame {
    /**
     * Frame del proyecto
     */
    public Desktop() {
        super("Seros");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setContentPane(new Contenedor());
        setExtendedState(MAXIMIZED_BOTH);
        setIconImage(Objects.requireNonNull(Archivos.image("/recourses/image/logo.png", -1, 52)).getImage());
    }
}