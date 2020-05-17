package com.moshkova.elena.frame;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class OrderModel extends AbstractTableModel {
    public static final long seriaVersion = 4735890989L;
    private int columnCount = 3;
    private ArrayList<String []> dataAarrayList;

    public OrderModel() {
        dataAarrayList = new ArrayList<>();
        for(int i = 0; i < dataAarrayList.size(); i++){
            dataAarrayList.add(new String[getColumnCount()]);
        }

    }

    @Override
    public int getRowCount() {
        return dataAarrayList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] rows = dataAarrayList.get(rowIndex);
        return rows[columnIndex];
    }
    @Override
    public String getColumnName(int columnIndexc) {
        switch (columnIndexc) {
            case 0: return "Продукт";
            case 1: return "Количество";
            case 2: return "Цена";
        }
        return "";
    }

    public void addDate(String[] row) {
        String[] rowTable = new String [getColumnCount()];
        rowTable =row;
        dataAarrayList.add(rowTable);
    }
}
