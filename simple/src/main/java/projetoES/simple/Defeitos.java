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

	/**Reads all given data and adds values to DCI, DII, ADCI, ADII according to specific conditions 
	 * @return String [][] with all saved values
	 */
	public String[][] detecaoDefeitos() {
		for(int i=0; i< dadosExcel.length; i++) {
			if((dadosExcel[i][8].equals("TRUE")) &&
					(dadosExcel[i][9].equals("TRUE") || dadosExcel[i][10].equals("TRUE"))) {
				DCI++;
			}
			else if((dadosExcel[i][8].equals("FALSE")) &&
					(dadosExcel[i][9].equals("TRUE") || dadosExcel[i][10].equals("TRUE"))) {
				DII++;
			}
			else if((dadosExcel[i][8].equals("FALSE")) &&
					(dadosExcel[i][9].equals("FALSE") || dadosExcel[i][10].equals("FALSE"))) {
				ADCI++;
			}
			else if((dadosExcel[i][8].equals("TRUE")) &&
					(dadosExcel[i][9].equals("FALSE") || dadosExcel[i][10].equals("FALSE"))) {
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