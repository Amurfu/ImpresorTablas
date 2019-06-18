package com.ttracasa.impresor;

//� 2019 Luis Esparza, All rights reserved
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JTable;

/**
 *
 * @author LeedMx <esparza.mexico@gmail.com>
 */
public class ImpresorTabla {
    
    
    public void imprimirJTable(String nombreArchivo, JTable table) throws IOException {
        FileWriter escritor = new FileWriter(nombreArchivo);
        PrintWriter escritorFormato = new PrintWriter(escritor);
        escritorFormato.println(encabezadosTabla(table));
        for (int row = 0 ; row < table.getRowCount() ; row++) 
            escritorFormato.println(filaCommaSeparated(table, row));
        escritorFormato.close(); 
        escritor.close();
    }
    
    private String encabezadosTabla(JTable table){
        String string = "";
        for (int i = 0 ; i < table.getColumnCount() ; i++)
            string += String.format("%s,", table.getColumnName(i));
        return cropLast(string);
    }

    private String filaCommaSeparated(JTable table, int row){
        String string = "";
        for (int column = 0 ; column < table.getColumnCount() ; column++)
            string += String.format("%s,", table.getValueAt(row, column));
        return cropLast(string);
    }

    private String cropLast(String linea) {
        return linea.substring(0, linea.length() - 1);
    }
    
}
