package alura.Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.optionconfig.animation.Animation;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;
import org.primefaces.model.charts.optionconfig.title.Title;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;

import alura.DAO.DAO;
import alura.DAO.LivroDAO;
import alura.DAO.VendaDAO;
import alura.Modelo.Livro;
import alura.Modelo.Venda;

@Named
@ViewScoped // javax.faces.view.ViewScoped;
public class VendaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private BarChartModel barModel;
	private PieChartModel pieModel;
	
	@Inject
	private VendaDAO vendaDAO;
	
	@Inject
	private LivroDAO livroDAO;
	
	
	@PostConstruct
    public void init() {
		createPieModel();
        createBarModel();
    }
	//TODO  TESTE
	private void createPieModel() {
        pieModel = new PieChartModel();
        ChartData data = new ChartData();
        
        PieChartDataSet dataSet = new PieChartDataSet();
        List<Number> values = new ArrayList<>();
        values.add(300);
        values.add(50);
        values.add(100);
        dataSet.setData(values);

        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(255, 99, 132)");
        bgColors.add("rgb(54, 162, 235)");
        bgColors.add("rgb(255, 205, 86)");
        dataSet.setBackgroundColor(bgColors);

        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        labels.add("Red");
        labels.add("Blue");
        labels.add("Yellow");
        data.setLabels(labels);

        pieModel.setData(data);
    }
	
    public PieChartModel getPieModel() {
        return pieModel;
    }
	
	public void createBarModel() {
        barModel = new BarChartModel();
        ChartData data = new ChartData();

        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("Vendas 2016");

        List<Venda> vendas = getVendas(4123); // Supondo que isso retorna a lista de vendas

        List<Number> valoresVendas = new ArrayList<>();
        for (Venda venda : vendas) {
            valoresVendas.add(venda.getQuantidade()); // Supondo que "quantidade" é o atributo numérico desejado
        }

        barDataSet.setData(valoresVendas);
        

        List<String> bgColor = new ArrayList<>();
        bgColor.add("rgba(255, 99, 132, 1)");
        bgColor.add("rgba(255, 159, 64, 1)");
        bgColor.add("rgba(255, 205, 86, 1)");
        bgColor.add("rgba(75, 192, 192, 1)");
        bgColor.add("rgba(54, 162, 235, 1)");
        bgColor.add("rgba(153, 102, 255, 1)");
        bgColor.add("rgba(201, 203, 207, 1)");
        barDataSet.setBackgroundColor(bgColor);

        List<String> borderColor = new ArrayList<>();
        borderColor.add("rgb(255, 99, 132)");
        borderColor.add("rgb(255, 159, 64)");
        borderColor.add("rgb(255, 205, 86)");
        borderColor.add("rgb(75, 192, 192)");
        borderColor.add("rgb(54, 162, 235)");
        borderColor.add("rgb(153, 102, 255)");
        borderColor.add("rgb(201, 203, 207)");
        barDataSet.setBorderColor(borderColor);
        barDataSet.setBorderWidth(1);

        data.addChartDataSet(barDataSet);

        List<String> NomeVendas = new ArrayList<>();
        for (Venda venda : vendas) {
        	NomeVendas.add(venda.getLivro().getTitulo()); 
        }
        data.setLabels(NomeVendas);
        barModel.setData(data);



        //Options
        BarChartOptions options = new BarChartOptions();
        options.setMaintainAspectRatio(false);
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        linearAxes.setBeginAtZero(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);

        Title title = new Title();
        title.setDisplay(true);
        title.setText("Bar Chart");
        options.setTitle(title);

        Legend legend = new Legend();
        legend.setDisplay(true);
        legend.setPosition("top");
        LegendLabel legendLabels = new LegendLabel();
        legendLabels.setFontStyle("italic");
        legendLabels.setFontColor("#2980B9");
        legendLabels.setFontSize(24);
        legend.setLabels(legendLabels);
        options.setLegend(legend);

        // disable animation
        Animation animation = new Animation();
        animation.setDuration(2);
        options.setAnimation(animation);

        barModel.setOptions(options);
    }
	
	public BarChartModel getBarModel() {
		return barModel;
	}



	public List<Venda> getVendas(long seed) {
		
		List<Venda> vendas = new ArrayList<Venda>();
		List<Livro> livros = livroDAO.listaTodos();

		Random random = new Random(seed);
		for ( Livro livro : livros) {
			Integer quantidade = random.nextInt(500);
			
			vendas.add(new Venda(livro, quantidade));
		}
		
		return vendas;
	}

	
	
	
	
	
	public VendaDAO getVendaDAO() {
		return vendaDAO;
	}
	public void setVendaDAO(VendaDAO vendaDAO) {
		this.vendaDAO = vendaDAO;
	}
	public LivroDAO getLivroDAO() {
		return livroDAO;
	}
	public void setLivroDAO(LivroDAO livroDAO) {
		this.livroDAO = livroDAO;
	}
	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}
	
    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

	
	
}
