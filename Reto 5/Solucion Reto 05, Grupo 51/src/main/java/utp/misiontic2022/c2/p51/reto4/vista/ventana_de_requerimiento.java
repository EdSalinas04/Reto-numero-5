package utp.misiontic2022.c2.p51.reto4.vista;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import utp.misiontic2022.c2.p51.reto4.controlador.ControladorRequerimientos;
import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_3;


public class ventana_de_requerimiento extends JFrame {

    //CONTROLADOR PARA LOS REQUERIMIENTOS

    private ControladorRequerimientos controlador ;

    private JTable tabla;
    private JTable tabla2;
    private JTable tabla3;
    

    public ventana_de_requerimiento(){

        controlador = new  ControladorRequerimientos();

        initUI();
        setLocationRelativeTo(null); 
    }

    //GENERADOR DE VENTANA PARA LOS REQUERIMIENTOS

    private void initUI(){
        setTitle("Interfaz del reto 5");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);

        var np = new JTabbedPane();

        getContentPane().add(np, BorderLayout.CENTER);

        //GENERADO Y CONTROLADOR DEL 1ER REQUERIMIENTO

        var panel = new JPanel();

        panel.setLayout(new BorderLayout()); 
        np.addTab("Consulta de Requerimiento 1", panel);

        var panelDeEntrada = new JPanel();

        panelDeEntrada.add(new JLabel("Requerimiento 01 "));

        var botonConsulta = new JButton("¡¡Consultar!!");

        botonConsulta.addActionListener(e -> cargarTablaDeConsulta());

        panelDeEntrada.add(botonConsulta);

        panel.add(panelDeEntrada, BorderLayout.PAGE_START);

        tabla = new JTable();
        panel.add(new JScrollPane(tabla) , BorderLayout.CENTER);

        //GENERADOR DEL 2DO REQUERIMIENTO

        var panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        np.addTab("Consulta de Requerimiento 2", panel2);

        var panelEntrada2 = new JPanel();
        panelEntrada2.add(new JLabel("Requerimiento 02"));

        var botonConsulta2 = new JButton("¡Consular!");

        botonConsulta2.addActionListener(e -> cargarTablaDeconsulta2());

        panelEntrada2.add(botonConsulta2);

        panel2.add(panelEntrada2, BorderLayout.PAGE_START);
        
        tabla2 = new JTable();
        panel2.add(new JScrollPane(tabla2), BorderLayout.CENTER);

        //GENERADOR DEL 3ER REQUERIMIENTO

        var panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());

        np.addTab("Consulta de Requerimiento 3", panel3);

        var panelEntrada3 = new JPanel();
        panelEntrada3.add(new JLabel("Requerimiento 03"));

        var botonConsulta3 = new JButton("¡Consular!!");

        botonConsulta3.addActionListener(e -> cargarTablaDeconsulta3());

        panelEntrada3.add(botonConsulta3);

        panel3.add(panelEntrada3, BorderLayout.PAGE_START);
        
        tabla3 = new JTable();
        panel3.add(new JScrollPane(tabla3), BorderLayout.CENTER);



    }

    //TABLAS DE CONSULTA

    //TABLA DEL 1ER REQUERIMIENTO

    private void cargarTablaDeConsulta() {
        
        try {
            var lista = controlador.consultarRequerimiento1();
            var tableModel = new Requerimiento1TableModel();

            tableModel.setData(lista); 

            tabla.setModel(tableModel);


        } catch (SQLException e) {

            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    //TABLA DEL 2DO REQUERIMIENTO
    private void cargarTablaDeconsulta2() {
        
        try {
            var lista2 = controlador.consultarRequerimiento2();
            var tableModel2 = new requerimiento2TableModel();
            tableModel2.setDatos(lista2);

            tabla2.setModel(tableModel2);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    //TABLA DEL 3ER REQUERIMIENTO

    private void cargarTablaDeconsulta3() {
        
        try {
            var lista3 = controlador.consultarRequerimiento3();
            var tableModel3 = new requerimiento3TableModel();
            tableModel3.setDatas(lista3);

            tabla3.setModel(tableModel3);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    //DATOS DE LOS REQUERIMIENTOS

    //DATOS DEL 1ER REQUERIMIENTO
    private class Requerimiento1TableModel extends AbstractTableModel{

        private ArrayList<Requerimiento_1> data;

        public void setData(ArrayList<Requerimiento_1> data){
            this.data = data;
        }

        @Override
        public String getColumnName(int column) {
            
            switch(column){
                case 0:
                    return "Nombre Material";
                case 1:
                    return "Precio por Unidad";
                
            }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            
            var registro = data.get(rowIndex);

            switch(columnIndex){
                case 0:
                    return registro.getNombreMaterial();
                case 1:
                    return registro.getPrecioUnidad();
                
            }
            
            return null;
        }

    }

    // DATOS DEL 2DO REUQERIMIENTO

    private class requerimiento2TableModel extends AbstractTableModel{

        private ArrayList<Requerimiento_2>datos;

        public void setDatos(ArrayList<Requerimiento_2> datos) {
            this.datos = datos;
        }

        @Override
        public String getColumnName(int column) {
            switch(column){
                case 0:
                    return "Constructora";
                case 1:
                    return "Ciudad";}
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            return datos.size();
        }

        @Override
        public int getColumnCount() {
                 return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            
            var registro = datos.get(rowIndex);

            switch(columnIndex){
                case 0:
                    return registro.getConstructora();
                case 1:
                    return registro.getCiudad();
            }
            return null;
        }


    }

    //DATOS DEL 3ER REQUERIMIENTO

    private class requerimiento3TableModel extends AbstractTableModel{

        private ArrayList<Requerimiento_3> datas;

        public void setDatas(ArrayList<Requerimiento_3> datas) {
            this.datas = datas;
        }

        @Override
        public String getColumnName(int column) {

            switch(column){
                case 0:
                    return "Proveedor";
                case 1:
                    return "Nombre del Maetial";
                case 2:
                    return "Importado";
                case 3:
                    return "Precio por Unidad";
                case 4:
                    return "Cantidad";}

             return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            return datas.size();
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            
            var registro = datas.get(rowIndex);

            switch(columnIndex){
                case 0:
                    return registro.getProveedor();
                case 1:
                    return registro.getNombreMaterial();
                case 2:
                    return registro.getImportado();
                case 3:
                    return registro.getPrecioUnidad();
                case 4:
                    return registro.getCantidad();}
            

            return null;
        }
        
        


    }
}