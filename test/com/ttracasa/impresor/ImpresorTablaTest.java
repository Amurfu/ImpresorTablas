/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttracasa.impresor;

import java.io.File;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import junitx.framework.FileAssert;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Esparza
 */
public class ImpresorTablaTest {
    
    @Test
    public void testImprimirTabla() throws Exception {
        String[] encabezados = new String[]{"encabezado1","encabezado2"};
        String[] fila1 = new String[]{"A2","B2"};
        String[] fila2 = new String[]{"A3","B3"};
        String[][] datos = new String[2][2];
        datos[0] = fila1;
        datos[1] = fila2;
        
        JTable tabla = new JTable();
        tabla.setModel(new DefaultTableModel(datos, encabezados));
        
        ImpresorTabla impresor = new ImpresorTabla();
        
        impresor.imprimirJTable("test.csv", tabla);
        
        File expected = new File("sampleCSV.csv");
        File actual = new File("test.csv");
        
        FileAssert.assertEquals(expected, actual);
        assertTrue( actual.delete() );
    }
    
}
