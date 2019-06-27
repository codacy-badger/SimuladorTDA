package eventos;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.text.DecimalFormat;
import gui.contenido.About;
import gui.contenido.Switch;
import gui.contenido.Tree;
import gui.contenido.scroll.ModernScrollPane;
import tools.Paneles;
public abstract class Eventos {
    /**
     * Variable estatica que contiene todos los paneles agregados al proyecto
     */
    private static JPanel panel;
    /**
     *Establece el panel principal que contiene todos los paneles de proyecto
     * @param panel {@link JPanel}
     * @author Sergio Majé
     */
    public static void setPanel(JPanel panel){
        Eventos.panel=panel;
    }
    /**
     * Mediante el nombre de los paneles definidos mediante un enum de String muestra el panel deseado en la intefaz grafica
     * @see Paneles
     * @param panel {@link String}
     * @author Sergio Majé
     */
    public static void show(Paneles panel){
        ((CardLayout)Eventos.panel.getLayout()).show(Eventos.panel,panel.toString());
    }
    /**
     * abre el navegador con el link fijado
     * @param url {@String} url a abrir por el usuario
     * @author Sergio Majé
     */
    public static void link(String url){
        try{
            if (Desktop.isDesktopSupported()) Desktop.getDesktop().browse(new URL(url).toURI());
        } catch (Exception e) {
            //None
        }
    }
    /**
     * About de Seros,<br>
     * se ejecuta una única vez por ejecución
     * @param component {@Component} componente en el cual se va a ejecutar el about
     */
    public static void about(Component component){
        if (About.show) {
            About.show=false;
            new About(component).setVisible(true);
        }
    }
    /**
     * Modifica el disponibilidad de los componentes dados
     * @param enable disponibilidad a dar a los componentes
     * @param components componentes a modificar disponibilidad
     * @author Sergio Majé
     */
    public static void enable(boolean enable,Component... components) {
        for (Component component : components) if (component instanceof Switch) ((Switch) component).setModificable(enable);
        else component.setEnabled(enable);
    }
    /**
     * Valor a la posición del scroll dado
     * @param pane scroll a posicionar
     * @param value posición a dar al scroll
     * @author Sergio Majé
     */
    public static void scroll(ModernScrollPane pane, int value){
        pane.getVerticalScrollBar().setValue(value);
    }
    /**
     * Valor a dar a una variable de un determinado nodo del árbol
     * @param tree árbol a trabajar
     * @param index posición de la variable
     * @param valor valor a dar a la variable en el árbol
     * @author Sergio Majé
     */
    public static void variable(Tree tree,int index,Object valor){
        tree.getDato(index).setValor(valor.toString());
        tree.updateUI();
    }
    /**
     * Duerme el la ejecución lineal del proceso por los milisegundo establecidos
     * @param mili milisegundos a establecer
     */
    public static void sleep(long mili){
        try {
            Thread.sleep(mili);
        } catch (InterruptedException e) {
            //None
        }
    }
    public static String formatNumber(Object number,String pattern){
        return new DecimalFormat(pattern).format(number);
    }
}