package com.moshkova.elena.gui;

import com.moshkova.elena.models.ListProducts;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class OrderModel extends AbstractTableModel {
    public static final long seriaVersion = 4735890989L;
    protected static final String COLUMNN_NAMES[] = {"Продукт", "Количество", "Цена"};

    private List<ListProducts> listProductsList;

    public OrderModel(List<ListProducts> listProductsList) {
        this.listProductsList = new ArrayList<>(listProductsList);
        }

    public ListProducts getListProductsAt(int row) {
        return listProductsList.get(row);
    }

    public void removeRow(int row) {
        listProductsList.remove(row);
    }

    @Override
    public int getRowCount() {
        return listProductsList.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNN_NAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMNN_NAMES[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ListProducts listProducts = listProductsList.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = listProducts.getProduct();
                break;
            case 1:
                value = listProducts.getCount();
                break;
            case 2:
                value = listProducts.getOrderPrice();
                break;
        }
        return value;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex == 1) {
            ListProducts listProducts = listProductsList.get(rowIndex);
            listProducts.setCount((Integer)aValue);
            super.setValueAt(aValue, rowIndex, columnIndex);
            fireTableCellUpdated(rowIndex,columnIndex);
        }
    }

    public void update (ListProducts listProducts) {
        int row = listProductsList.indexOf(listProducts);
        fireTableRowsUpdated(row, row);
    }
}
