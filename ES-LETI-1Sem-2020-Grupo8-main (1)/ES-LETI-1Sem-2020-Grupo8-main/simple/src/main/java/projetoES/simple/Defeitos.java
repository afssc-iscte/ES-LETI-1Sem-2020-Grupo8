package projetoES.simple;

public class Defeitos {

	private String[][] dadosExcel;
	private String[] header= {"Defeitos", "Total"};
	private int DCI=0;
	private int DII=0;
	private int ADCI=0;
	private int ADII=0;
	private String [][] resultados= {{"DCI", Integer.toString(DCI)}, {"DII", Integer.toString(DII)},
			{"ADCI",Integer.toString(ADCI)}, {"ADII",Integer.toString(ADII)}};


	public Defeitos(String [][] dadosExcel) {
		this.dadosExcel=dadosExcel;
	}

	public String[][] detecaoDefeitos() {
		for(int i=0; i< dadosExcel.length; i++) {
			if(Boolean.parseBoolean(dadosExcel[i][8]) == true &&
					(Boolean.parseBoolean(dadosExcel[i][9]) == true || Boolean.parseBoolean(dadosExcel[i][10]) == true) ) {
				DCI++;
			}
			else if(Boolean.parseBoolean(dadosExcel[i][8]) == false &&
					(Boolean.parseBoolean(dadosExcel[i][9]) == true || Boolean.parseBoolean(dadosExcel[i][10]) == true)) {
				DII++;
			}
			else if(Boolean.parseBoolean(dadosExcel[i][8]) == false &&
					(Boolean.parseBoolean(dadosExcel[i][9]) == false || Boolean.parseBoolean(dadosExcel[i][10]) == false)) {
				ADCI++;
			}
			else if(Boolean.parseBoolean(dadosExcel[i][8]) == true &&
					(Boolean.parseBoolean(dadosExcel[i][9]) == false || Boolean.parseBoolean(dadosExcel[i][10]) == false)) {
				ADII++;
			}
		}

		resultados[0][1]=Integer.toString(DCI);
		resultados[1][1]=Integer.toString(DII);
		resultados[2][1]=Integer.toString(ADCI);
		resultados[3][1]=Integer.toString(ADII);
		return resultados;
	}

	public String[] getHeader() {
		return header;
	}

	public void setHeader(String[] header) {
		this.header = header;
	}


}
