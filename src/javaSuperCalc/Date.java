package javaSuperCalc;

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
