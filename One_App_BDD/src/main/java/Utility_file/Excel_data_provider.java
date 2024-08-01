package Utility_file;

public interface Excel_data_provider {
	public String excel_getdata(int sheetno, int row_No, int col_No);

	public int getRowCount(int sheetno);

	public int getColCount(int sheetno);

	public void excel_writedata(int sheetno, int row_No, int col_No, String value);

}
