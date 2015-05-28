package javaSuperCalc;

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
