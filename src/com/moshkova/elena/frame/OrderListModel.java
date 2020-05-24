package com.moshkova.elena.frame;

import com.moshkova.elena.programma.ListProducts;
import com.moshkova.elena.programma.Order;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderListModel extends AbstractTableModel {
    public static final long seriaVersion = 4735989L;
    private int columnCount = 3;
    private ArrayList<String []> dataAarrayList;

    public OrderListModel() {
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
            case 0: return "Номер заказа";
            case 1: return "Дата создания";
            case 2: return "Владелец";
            }
        return "";
    }

    public void addDate(String[] row) {
        String[] rowTable = new String [getColumnCount()];
        rowTable =row;
        dataAarrayList.add(rowTable);
    }
}
