//� 2019 Luis Esparza, All rights reserved
package com.ttracasa.impresor;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JTable;

/**
 *
 * @author LeedMx <esparza.mexico@gmail.com>
 */
public class ImpresorTabla {
    
    /**
     * 
     * @param nombreArchivo
     * @param jTable
     * @throws IOException
     */
    public void imprimirJTable(String nombreArchivo, JTable jTable) throws IOException {
        try (   FileWriter escritor = new FileWriter(nombreArchivo); 
                PrintWriter escritorFormato = new PrintWriter(escritor); ) {
            escritorFormato.println(encabezadosTabla(jTable));
            for (int row = 0 ; row < jTable.getRowCount() ; row++)
                escritorFormato.println(filaCommaSeparated(jTable, row));
        }
    }
    
    private String encabezadosTabla(JTable table){
        String string = "";
        for (int i = 0 ; i < table.getColumnCount() ; i++)
            string += String.format("\"%s\",", table.getColumnName(i));
        return cropLast(string);
    }

    private String filaCommaSeparated(JTable table, int row){
        String string = "";
        for (int column = 0 ; column < table.getColumnCount() ; column++)
            string += String.format("\"%s\",", table.getValueAt(row, column));
        return cropLast(string);
    }

    private String cropLast(String linea) {
        return linea.substring(0, linea.length() - 1);
    }
    
}
