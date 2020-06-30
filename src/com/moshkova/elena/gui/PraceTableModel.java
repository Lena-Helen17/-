package com.moshkova.elena.gui;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class PraceTableModel extends AbstractTableModel {
    public static final long seriaVersion = 473589L;
    private int columnCount = 4;
    private ArrayList<String []> dataAarrayList;

    public PraceTableModel() {
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
            case 0: return "Артикул";
            case 1: return "Наименование";
            case 2: return "Цвет";
            case 3: return "Цена";
        }
        return "";
    }

    public void addDate(String[] row) {
        String[] rowTable = new String [getColumnCount()];
        rowTable =row;
        dataAarrayList.add(rowTable);
    }
    // int sel = 0; // или номер строки или getSelestedRow
    // model.removeRow(sel); // удаление выбранной строки
}

