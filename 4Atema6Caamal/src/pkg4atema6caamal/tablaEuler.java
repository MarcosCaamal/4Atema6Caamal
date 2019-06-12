/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4atema6caamal;

/**
 *
 * @author m
 */
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
public class tablaEuler extends AbstractTableModel{
     public String[] columnas={"Xi", "Yi+1"};
    public Class[] tipos={Double.class, Double.class};
    private ArrayList<filaEuler> filas;
    
    public tablaEuler(ArrayList<filaEuler> filas){
        this.filas=filas;
    }
    
    @Override
    public int getRowCount() {
        return this.filas.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnas.length;
    }

    @Override
    public Object getValueAt(int iFila, int iColumna) {
        filaEuler fila=this.filas.get(iFila);
       
          switch(iColumna){
            case 0: return fila.getXi();
            case 1: return fila.getYi();
        
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
           return false;
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return this.tipos[i]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int i) {
        return this.columnas[i]; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
