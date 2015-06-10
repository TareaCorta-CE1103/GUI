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

public class Grafico {
    public static void main(String[] args) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        double tiempoDeEjecucion = 100;
        double mejorCaso;
        double peorCaso;
        double casoPromedio;

        for (int cantidadDeElementos = 100; cantidadDeElementos < 10001; 
                cantidadDeElementos = cantidadDeElementos *10) {
            
            tiempoDeEjecucion = tiempoDeEjecucion *2;
            mejorCaso = tiempoDeEjecucion;
            dataset.addValue(mejorCaso, "Mejor caso", "" + cantidadDeElementos);
    
            peorCaso = tiempoDeEjecucion * 5;
            dataset.addValue(peorCaso, "Peor caso", "" + cantidadDeElementos);
 
            casoPromedio = tiempoDeEjecucion *7;
            dataset.addValue(casoPromedio, "Caso promedio",
                    "" + cantidadDeElementos);
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
}
 

