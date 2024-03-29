package gui.editor;
import gui.contenido.scroll.ModernScrollPane;
import tools.Archivos;
import tools.Colour;
public class Editor extends ModernScrollPane{
    /**
     * Editor sintexico de código a utilizar en la interfaz grafica del proyecto
     */
    private Editor(View view, Indice indice) {
        super(view, indice);
    }
    /**
     * Decodifica el texto del archivo para diferenciar los diferentes colores de la sintaxis
     * @param n {@link String} cadena con texto codificado
     */
    private void text(String n) {
        for (String e:n.replaceAll("\t","   ").split("_")){
            if (e.endsWith("n")) ((View)getView()).append(e.substring(0,e.length()-1), Colour.NARANJA.getColor());
            else if(e.endsWith("m")) ((View)getView()).append(e.substring(0,e.length()-1), Colour.MORADO.getColor());
            else if(e.endsWith("a")) ((View)getView()).append(e.substring(0,e.length()-1), Colour.AMARILLO.getColor());
            else if(e.endsWith("b")) ((View)getView()).append(e.substring(0,e.length()-1), Colour.AZUL.getColor());
            else if(e.endsWith("v")) ((View)getView()).append(e.substring(0,e.length()-1), Colour.VERDE.getColor());
            else if(e.endsWith("w")) ((View)getView()).append(e.substring(0,e.length()-1), Colour.BLANCO.getColor());
        }
    }
    /**
     * Selecciona una linea determinada
     * @param i linea a seleccionar
     */
    public void drawLineIn(int i){
        ((View)getView()).drawLineIn(i);
        ((Indice)getIndice()).lineForegroundIn(i);
    }
    /**
     * Fija si la linea se dibuja
     * @param line true: Se dibuja false: No se dibuja
     */
    public void setLine(boolean line){
        ((View)getView()).setLine(line);
        ((Indice)getIndice()).lineForegroundIn(-1);
    }
    /**
     * Define texto al view sin diferenciación de sintaxis
     * @param text {@link String}
     */
    public void setText(String text){
        ((View)getView()).setText(text);
    }
    /**
     * Creación de un nuevo Editor
     * @param path {@link String} ruta del archivo a mostrar
     * @return editor con contenido integrado
     * @see Archivos#codefiles(String)
     */
    public static Editor editor(String path){
        View view=new View();
        Editor editor=new Editor(view,new Indice(view));
        editor.text(Archivos.codefiles(path));
        return editor;
    }
}