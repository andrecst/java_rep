import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class winJavaSuperCalc {

	private JFrame frame;
	private JLabel lblOperacao;
	private JLabel lblResultado;
	private JLabel lblMem;
	
	private String operacao = "";
	private String memoria = "";
	
	operationsSuperCalc calc = new operationsSuperCalc();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					winJavaSuperCalc window = new winJavaSuperCalc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public winJavaSuperCalc() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 278, 297);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResultado.setBounds(10, 31, 242, 14);
		frame.getContentPane().add(lblResultado);
		lblResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblOperacao = new JLabel("");
		lblOperacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOperacao.setBounds(31, 11, 221, 14);
		frame.getContentPane().add(lblOperacao);
		lblOperacao.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblMem = new JLabel("M");
		lblMem.setHorizontalAlignment(SwingConstants.CENTER);
		lblMem.setBounds(10, 11, 22, 14);
		lblMem.setVisible(false);
		frame.getContentPane().add(lblMem);
		
		// 00
		JButton btnN0 = new JButton("0");
		btnN0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				operacao += "0";
				lblOperacao.setText(operacao);
			}
		});
		btnN0.setBounds(10, 192, 53, 23);
		frame.getContentPane().add(btnN0);
		
		// 01
		JButton btnN1 = new JButton("1");
		btnN1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				operacao += "1";
				lblOperacao.setText(operacao);
			}
		});
		btnN1.setBounds(10, 90, 53, 23);
		frame.getContentPane().add(btnN1);
		
		// 02
		JButton btnN2 = new JButton("2");
		btnN2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				operacao += "2";
				lblOperacao.setText(operacao);
			}
		});
		btnN2.setBounds(73, 90, 53, 23);
		frame.getContentPane().add(btnN2);
		
		// 03
		JButton btnN3 = new JButton("3");
		btnN3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				operacao += "3";
				lblOperacao.setText(operacao);
			}
		});
		btnN3.setBounds(136, 90, 53, 23);
		frame.getContentPane().add(btnN3);
		
		// 04
		JButton btnN4 = new JButton("4");
		btnN4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				operacao += "4";
				lblOperacao.setText(operacao);
			}
		});
		btnN4.setBounds(10, 124, 53, 23);
		frame.getContentPane().add(btnN4);
		
		// 05
		JButton btnN5 = new JButton("5");
		btnN5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				operacao += "5";
				lblOperacao.setText(operacao);
			}
		});
		btnN5.setBounds(73, 124, 53, 23);
		frame.getContentPane().add(btnN5);
		
		// 06
		JButton btnN6 = new JButton("6");
		btnN6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				operacao += "6";
				lblOperacao.setText(operacao);
			}
		});
		btnN6.setBounds(136, 124, 53, 23);
		frame.getContentPane().add(btnN6);
		
		// 07
		JButton btnN7 = new JButton("7");
		btnN7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				operacao += "7";
				lblOperacao.setText(operacao);
			}
		});
		btnN7.setBounds(10, 158, 53, 23);
		frame.getContentPane().add(btnN7);
		
		// 08
		JButton btnN8 = new JButton("8");
		btnN8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				operacao += "8";
				lblOperacao.setText(operacao);
			}
		});
		btnN8.setBounds(73, 158, 53, 23);
		frame.getContentPane().add(btnN8);
		
		// 09
		JButton btnN9 = new JButton("9");
		btnN9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				operacao += "9";
				lblOperacao.setText(operacao);
			}
		});
		btnN9.setBounds(136, 158, 53, 23);
		frame.getContentPane().add(btnN9);
		
		// +
		JButton btnMais = new JButton("+");
		btnMais.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				operacao += "+";
				lblOperacao.setText(operacao);
			}
		});
		btnMais.setBounds(199, 90, 53, 42);
		frame.getContentPane().add(btnMais);
		
		// -
		JButton btnMenos = new JButton("-");
		btnMenos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				operacao += "-";
				lblOperacao.setText(operacao);
			}
		});
		btnMenos.setBounds(199, 139, 53, 42);
		frame.getContentPane().add(btnMenos);
		
		// *
		JButton btnVezes = new JButton("*");
		btnVezes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				operacao += "*";
				lblOperacao.setText(operacao);
			}
		});
		btnVezes.setBounds(136, 192, 53, 23);
		frame.getContentPane().add(btnVezes);
		
		// /
		JButton btnDivide = new JButton("/");
		btnDivide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				operacao += "/";
				lblOperacao.setText(operacao);
			}
		});
		btnDivide.setBounds(73, 192, 53, 23);
		frame.getContentPane().add(btnDivide);
		
		// ^
		JButton btnExpo = new JButton("^");
		btnExpo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				operacao += "^";
				lblOperacao.setText(operacao);
			}
		});
		btnExpo.setBounds(10, 224, 53, 23);
		frame.getContentPane().add(btnExpo);
		
		// (
		JButton btnAbrePar = new JButton("(");
		btnAbrePar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				operacao += "(";
				lblOperacao.setText(operacao);
			}
		});
		btnAbrePar.setBounds(73, 224, 53, 23);
		frame.getContentPane().add(btnAbrePar);
		
		// )
		JButton btnFechaPar = new JButton(")");
		btnFechaPar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				operacao += ")";
				lblOperacao.setText(operacao);
			}
		});
		btnFechaPar.setBounds(136, 224, 53, 23);
		frame.getContentPane().add(btnFechaPar);
		
		// M
		JButton btnM = new JButton("M");
		btnM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				memoria = lblResultado.getText();
				lblMem.setVisible(true);
			}
		});
		btnM.setBounds(10, 56, 53, 23);
		frame.getContentPane().add(btnM);
		
		// R
		JButton btnR = new JButton("R");
		btnR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				operacao += memoria;
				lblOperacao.setText(operacao);
				lblMem.setVisible(false);
			}
		});
		btnR.setBounds(73, 56, 53, 23);
		frame.getContentPane().add(btnR);
		
		// C
		JButton btnC = new JButton("C");
		btnC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				operacao = (operacao.length() < 1)? "" : operacao.substring(0, (operacao.length() - 1));
				lblOperacao.setText(operacao);
			}
		});
		btnC.setBounds(199, 56, 53, 23);
		frame.getContentPane().add(btnC);
		
		// CE
		JButton btnCe = new JButton("CE");
		btnCe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				operacao = "";
				lblOperacao.setText(operacao);
			}
		});
		btnCe.setBounds(136, 56, 53, 23);
		frame.getContentPane().add(btnCe);
		
		// =
		JButton btnIgual = new JButton("=");
		btnIgual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String opp = lblOperacao.getText();
				lblResultado.setText(calc.calculaAlgo(opp));
			}
		});
		btnIgual.setBounds(199, 192, 53, 55);
		frame.getContentPane().add(btnIgual);	
		
		
	}
}

// -----------------------------------------------------------------------------------

public class operationsSuperCalc {
	String[] pilha = new String[100];
	int ip = 0;
	
	private void empilha(String st){
		pilha[ip] = st;
		ip++;
	}
	
	private String desempilha(){
		ip--;
		return pilha[ip];
	}
	
	private boolean isNan(String s){
		return s.matches("[0-9]*");
	}
	
	private boolean isOp(String s){
		return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")
				|| s.equals("^"));
	}
	
	private String calculaExpressao(String exp){
		try {
			if (!exp.substring(exp.length() - 1).equals(")")) exp += ")";
			String ch = "", num = "", op = "";
			float val1 = 0, val2 = 0;
			for (int i = 0; i < exp.length(); i++){
				ch = String.valueOf(exp.charAt(i));
				while (isNan(ch) || ch.equals(".")){
					num += ch;
					i++;
					ch = String.valueOf(exp.charAt(i));
				}
				if (!num.equals("")){
					empilha(num);
					num = "";
				}
				if (ch.equals(")") || (ip > 2 && isOp(ch))){
					val2 = Float.parseFloat(desempilha());
					op = desempilha();
					val1 = Float.parseFloat(desempilha());
					switch (op){
					case "+": empilha(String.valueOf(val1 + val2)); break;
					case "-": empilha(String.valueOf(val1 - val2)); break;
					case "*": empilha(String.valueOf(val1 * val2)); break;
					case "/": empilha(String.valueOf(val1 / val2)); break;
					case "^": empilha(String.valueOf(Math.pow(val1, val2))); break;
					}
				}
				if (isOp(ch)){
					empilha(ch);
				}
			}
			return desempilha();
		} catch (Exception e) {
			return "deve ser totalmente parentesiada!";
		} finally {
			ip = 0;
		}
	}
	
	private String calculaData(String exp){
		try {
			Date dt = new Date(exp.substring(0, 10));
			if (!dt.validDate()) return "erro";
			if (exp.length() > 11){
				if (exp.charAt(10) == '+'){
					return dt.addDays(Long.parseLong(exp.substring(11))).writeDate();
				} else if (exp.length() == 21 && exp.charAt(10) == '-'){
					Date dt2 = new Date(exp.substring(11));
					if (!dt2.validDate()) return "erro";
					return String.valueOf(dt.subDates(dt2));
				} else if (exp.charAt(10) == '-'){
					return dt.subDays(Long.parseLong(exp.substring(11))).writeDate();
				}
			}
			return "deve ser dd/mm/yyyy+num ou data +/- data";
		} catch (Exception e) {
			return "erro";
		}
	}
	
	public String calculaAlgo(String exp){
		if (exp.length() > 10 && (exp.charAt(2) == '/' && exp.charAt(5) == '/')){
			return calculaData(exp);
		} else {
			return calculaExpressao(exp);
		}
	}
}

// --------------------------------------------------------------------------------------

public class Date {
	int components[] = new int[3];
	int spacer = 0;
	int format = 0;
	int terms[] = {0, 1 ,2};
	final static char spacers[] = {'/','-','.'};
	
	public Date(int d, int m, int y){
		components[0] = d;
		components[1] = m;
		components[2] = y;
	}
	
	public Date(String sd){
		dateToInt(sd);
	}
	
	public Date(){
		components[0] = 0;
		components[1] = 0;
		components[2] = 0;
	}
	
	public Date(Date d){
		components[0] = d.components[0];
		components[1] = d.components[1];
		components[2] = d.components[2];
	}

	private void dateToInt(String date){
		int p1 = -1, p2 = -1, d0, d1, d2;
		for (int i = 0;i < date.length(); i++)
			for (int j = 0; j <= 2; j++)
				if (date.charAt(i) == spacers[j]){
					if (p1 >= 0){
						p2 = i;
						break;
					}
					p1 = i;
				}
		if (p1 < 0 || p2 < 0){
			return;
		} else {
			if (date.charAt(p1) != date.charAt(p2)) return;
			else {
				if (date.charAt(p1) == '/') spacer = 0;
				if (date.charAt(p1) == '-') spacer = 1;
				if (date.charAt(p1) == '.') spacer = 2;
			}
			
			d0 = isNan(date.substring(0, p1))? Integer.parseInt(date.substring(0, p1)) : 0;
			d1 = isNan(date.substring(p1 + 1, p2))? Integer.parseInt(date.substring(p1 + 1, p2)) : 0;
			d2 = isNan(date.substring(p2 + 1))? Integer.parseInt(date.substring(p2 + 1)) : 0;
			if (d0 > d2){
				terms[0] = 2; terms[2] = 0;
			} else if (d1 >= d0){
				terms[0] = 1; terms[1] = 0;
			}
			components[terms[0]] = d0;
			components[terms[1]] = d1;
			components[terms[2]] = d2;
		}
	}
	
	public boolean validDate(){
		if (components[0] < 1 || components[1] < 1 || components[2] < 1)
			return false;
		if (components[1] < 1 || components[1] > 12)
			return false;
		if (components[0] < 1 || components[0] > daysMonth())
			return false;
		if (format == 4 && spacer != 2)
			return false;
		if (format == 1 && spacer != 0)
			return false;
		return true;
	}
	
	private boolean isLeapYear(){
		if (((components[2] % 4 == 0) && (components[2] % 100 != 0)) || components[2] % 400 == 0)
			return true;
		else return false;
	}
	
	private int daysMonth(){
		switch(components[1]){
			case 1: return 31;
			case 2: return ((isLeapYear())? 29 : 28);
			case 3: return 31;
			case 4: return 30;
			case 5: return 31;
			case 6: return 30;
			case 7: return 31;
			case 8: return 31;
			case 9: return 30;
			case 10: return 31;
			case 11: return 30;
			case 12: return 31;
			default: return -1;
		}
	}
	
	public String writeDate(){
		String strDate;
		if (!validDate()) return "Error";
		strDate = (components[terms[0]] <= 9)? "0" + String.valueOf(components[terms[0]]) : String.valueOf(components[terms[0]]);
		strDate += spacers[spacer];
		strDate += (components[terms[1]] <= 9)? "0" + String.valueOf(components[terms[1]]) : String.valueOf(components[terms[1]]);
		strDate += spacers[spacer];
		strDate += (components[terms[2]] <= 9)? "0" + String.valueOf(components[terms[2]]) : String.valueOf(components[terms[2]]);
		return strDate;
	}

	public Date addDays(long days){ //add days in a date and return a later date
		Date endDate = new Date();
		if (validDate()){
			endDate.components[0] = components[0];
			endDate.components[1] = components[1];
			endDate.components[2] = components[2];
			for (int i = 1; i <= days; i++){
				endDate.components[0]++;
				if (endDate.components[0] > endDate.daysMonth()){
					endDate.components[0] = 1;
					endDate.components[1]++;
				}
				if (endDate.components[1] > 12){
					endDate.components[1] = 1;
					endDate.components[2]++;
				}
			}
		}
		return endDate;
	}
	
	public Date subDays(long days){
		Date begDate = new Date();
		if (validDate()){
			begDate.components[0] = components[0];
			begDate.components[1] = components[1];
			begDate.components[2] = components[2];
			for (int i = 1; i <= days; i++){
				begDate.components[0]--;
				if (begDate.components[0] < 1){
					begDate.components[0] = begDate.daysMonth();
					begDate.components[1]--;
				}
				if (begDate.components[1] < 1){
					begDate.components[1] = 12;
					begDate.components[2]--;
				}
			}
		}
		return begDate;
	}
	
	public long subDates(Date tempDate){
		long days = 0;
		if (!validDate() || !tempDate.validDate()) return -1;
		if (!isHigher(tempDate)){
			while(!isEqual(tempDate)){
				tempDate.components[0]++;
				if (tempDate.components[0] > tempDate.daysMonth()){
					tempDate.components[0] = 1;
					tempDate.components[1]++;
				}
				if (tempDate.components[1] > 12){
					tempDate.components[1] = 1;
					tempDate.components[2]++;
				}
				days++;
			}
		} else {
			while(!isEqual(tempDate)){
				tempDate.components[0]--;
				if (tempDate.components[0] < 1){
					tempDate.components[0] = tempDate.daysMonth();
					tempDate.components[1]--;
				}
				if (tempDate.components[1] < 1){
					tempDate.components[1] = 12;
					tempDate.components[2]--;
				}
				days++;
			}
		}
		return days;
	}

	private boolean isNan(String s){
		return s.matches("[0-9]*");
	}
	
	private boolean isEqual(Date a){
		if (a.components[0] == components[0] &&
			a.components[1] == components[1] &&
			a.components[2] == components[2])
			return true;
		return false;
	}
	
	private boolean isHigher(Date a){
		if (a.components[2] > components[2]) return true;
		else if (a.components[1] > components[1]) return true;
		else if (a.components[0] > components[0]) return true;
		return false;
	}
}