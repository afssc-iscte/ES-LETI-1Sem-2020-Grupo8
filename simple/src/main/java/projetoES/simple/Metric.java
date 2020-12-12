package projetoES.simple;

public class Metric {
	private String name;
	private String symbol;
	private double value;
	
	public Metric(String name, String symbol, double value) {
		this.name=name;
		this.symbol=symbol;
		this.value=value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	
	public double getValue() {
		return this.value;
	}
	
	public void set(String symbol, double value) {
		this.symbol=symbol;
		this.value=value;
	}

	public String compare(String value) {
		Double aux = Double.parseDouble(value);
		switch (getSymbol()) {
		case "<":
			if (aux < getValue()) {
				return "TRUE";
			} else {
				return "FALSE";
			}
		case ">":
			if (aux > getValue()) {
				return "TRUE";
			} else {
				return "FALSE";
			}
		case "=":
			if (aux == getValue()) {
				return "TRUE";
			} else {
				return "FALSE";
			}
		}
		return "FALSE";
	}
}