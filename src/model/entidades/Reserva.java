package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numquarto;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numquarto, Date entrada, Date saida) {
		this.numquarto = numquarto;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Integer getNumquarto() {
		return numquarto;
	}

	public void setNumquarto(Integer numquarto) {
		this.numquarto = numquarto;
	}

	public Date getEntrada() {
		return entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public long duracao() {
		long diferenca = saida.getTime() - entrada.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void dataAtualizacao(Date entrada, Date saida) {
		this.entrada = entrada;
		this.saida = saida;
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+ numquarto
				+ ", Entrada: "
				+ sdf.format(entrada) 
				+ ", Saída: "
				+ sdf.format(saida)
				+ ", "
				+ duracao()
				+ " Noites";
				
	}
	
}
