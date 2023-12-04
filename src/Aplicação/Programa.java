package Aplicação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;
import model.execao.DominioExecao;

public class Programa {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Número do quarto: ");
			int numero = sc.nextInt();
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			Date entrada = sdf.parse(sc.next()); 
			System.out.print("Data de saída (dd/MM/yyyy): ");
			Date saida = sdf.parse(sc.next()); 
			
			Reserva reserva = new Reserva(numero, entrada, saida);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Insira os dados para atualizar a reserva:");
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			entrada = sdf.parse(sc.next()); 
			System.out.print("Data de saída (dd/MM/yyyy): ");
			saida = sdf.parse(sc.next()); 
			
			reserva.dataAtualizacao(entrada, saida);
			System.out.println("Reserva: " + reserva);
		}
		catch(ParseException e) {
			System.out.println("Data invalida.");
		}
		catch(DominioExecao e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro Inesperado!");
		}
		
		sc.close();
		}
	}
