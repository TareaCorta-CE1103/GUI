package graficacion;
/**
 *
 * @author luis
 */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import facade.facade;
import lists.ListaSdoble;
import lists.Nodo;

public class Grafico {
    
    private long _mejorCaso;
    private long _peorCaso;
    private long _casoPromedio;
    private facade facade;
    private ListaSdoble _mensajes;
    private ListaSdoble _rnd;
    private ListaSdoble _normal;
    private ListaSdoble _worst;
    
    public Grafico(ListaSdoble pMensaje) {
        facade= new facade();
        facade.setMensaje(pMensaje);
        _mensajes=facade.getMensajes();
        facade.run();
        _rnd=facade.getRand();
        _normal=facade.getNormal();
        _worst=facade.getWorst();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Nodo tmp=_mensajes.getHead();
        Nodo rnd= _rnd.getHead();
        Nodo normal=_normal.getHead();
        Nodo peor=_worst.getHead();
        while(tmp!=null){
            for (int cantidadDeElementos = 100; cantidadDeElementos < 10001; 
                    cantidadDeElementos = cantidadDeElementos *10) {
                setLines(dataset,(int)tmp.getData(), cantidadDeElementos,
                        rnd, normal, peor);
                rnd= rnd.getNext();
                normal=normal.getNext();
                peor=peor.getNext();
            }
            tmp=tmp.getNext();
        }
        JFreeChart Grafico = ChartFactory.createLineChart(
                "Eficiencia del algoritmo",
                "Cantidad de elementos",
                "Tiempo de ejecución",dataset,PlotOrientation.VERTICAL,true,
                false,false);
        //Se muestra el grafico
        ChartFrame fr = new ChartFrame("Gráfico", Grafico);
        fr.pack();
        fr.setVisible(true);
    }
    
    private void setLines(DefaultCategoryDataset pDataset, int pMetodo, 
             int pLenghtDatos,Nodo pRnd, Nodo pNorm, Nodo pWorst){  
        _mejorCaso =(long)pNorm.getData();
        pDataset.addValue(_mejorCaso, "Mejor caso de: "+pMetodo, "" + pLenghtDatos);
        _peorCaso = (long)pRnd.getData();
        pDataset.addValue(_peorCaso, "Peor caso de: "+pMetodo, "" + pLenghtDatos);
        _casoPromedio=(long)pWorst.getData();
        pDataset.addValue(_casoPromedio, "Caso promedio de: "+pMetodo,"" + pLenghtDatos);
    }
    
    public static void main(String[] args) {
        //Grafico nuevo =new  Grafico("inldinAV");
    }
}
 

