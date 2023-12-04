package Aplicação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
	
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int numero = sc.nextInt();
		System.out.print("Data de entrada (dd/MM/yyyy): ");
		Date entrada = sdf.parse(sc.next()); 
		System.out.print("Data de saída (dd/MM/yyyy): ");
		Date saida = sdf.parse(sc.next()); 
		
		if(!saida.after(entrada)) {
			System.out.println("Erro na reserva: A data de Saída deve ser posterior à data de Entrada!");
		}
		else {
			Reserva reserva = new Reserva(numero, entrada, saida);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Insira os dados para atualizar a reserva:");
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			entrada = sdf.parse(sc.next()); 
			System.out.print("Data de saída (dd/MM/yyyy): ");
			saida = sdf.parse(sc.next()); 
			
			Date agora = new Date();
			if(entrada.before(agora) || saida.before(agora)) {
				System.out.println("Erro na reserva: As datas de reserva para atualização devem ser datas futuras!");
			}
			else if(!saida.after(entrada)) {
				System.out.println("Erro na reserva: A data de Saída deve ser posterior à data de Entrada!");
			}
			else {
				reserva.dataAtualizacao(entrada, saida);
				System.out.println("Reserva: " + reserva);
			}
		}
		
		sc.close();
		}
	}
