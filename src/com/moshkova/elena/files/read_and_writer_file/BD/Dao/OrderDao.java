package com.moshkova.elena.files.read_and_writer_file.BD.Dao;

import com.moshkova.elena.files.read_and_writer_file.BD.ConnectionManadger;
import com.moshkova.elena.models.ListProducts;
import com.moshkova.elena.models.Order;
import com.moshkova.elena.models.Person;
import com.moshkova.elena.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class OrderDao {
    private static final String COUNT_STROC = "SELECT COUNT(*) FROM ptice_Order";
    private static final String INSERT_QUERY = "INSERT INTO ptice_Order(\"Имя\", \"Адрес\", \"Номер телефона\", \"Дата создания\", \"Статус\") VALUES (?, ?, ?, ?, ?);";
    private static final  String APDETE_QUERY = "UPDATE ptice_Order SET \"Статус\"= ? WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM ptice_Order";
    private static final String FIND_ALL = "SELECT * FROM listproductsorder WHERE id_order = ?";


    public HashMap<Integer,Order> prindAll () {
        HashMap<Integer, Order> orderList = new HashMap();

        try (Connection collection = ConnectionManadger.getConnection();
             Statement st = collection.createStatement();
             ResultSet resultSet = st.executeQuery(FIND_ALL_QUERY);
        ){
            while (resultSet.next()) {
                Integer x = resultSet.getInt("Номер заказа");
                Order order = resultSetToOrder(resultSet,x);
                orderList.put(x, order);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return orderList;
    }

    public Integer countStroc() {
        Integer contStrok = 0;
        try (Connection collection = ConnectionManadger.getConnection();
             Statement st = collection.createStatement();
             ResultSet resultSet = st.executeQuery(COUNT_STROC);
        ){
            resultSet.next();
            contStrok = resultSet.getInt(1);


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ge");
        }
        return contStrok;

    }

    public  Integer save(String name, String adres, String telefon, String data, String status) {
        try (Connection collection = ConnectionManadger.getConnection();
             PreparedStatement st = collection.prepareStatement(INSERT_QUERY);
        ){
            st.setString(1, name);
            st.setString(2,adres);
            st.setString(3,telefon);
            st.setString(4,data);
            st.setString(5,status);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка сохранения заказа");
            e.printStackTrace();
        }
        return 1;

    }

    public  Integer update(Integer ID, String status) {
        try (Connection collection = ConnectionManadger.getConnection();
             PreparedStatement st = collection.prepareStatement(APDETE_QUERY);
        ){
            st.setString(1,status);
            st.setInt(2,ID);


            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ID;

    }

    public Order resultSetToOrder(ResultSet resultSet, Integer x) throws SQLException {
        String dataStart = resultSet.getString("Дата создания");
        Person person = new Person(resultSet.getString("Имя"), resultSet.getString("Адрес"), resultSet.getString("Номер телефона"));
        Short discount = 0;
        String statusOrder = resultSet.getString("Статус");
        ArrayList<ListProducts> listProductsList= new ArrayList<>();

        try (Connection collection = ConnectionManadger.getConnection();
             PreparedStatement st = collection.prepareStatement(FIND_ALL);
        ){
            st.setInt(1, x);
            ResultSet rs = st.executeQuery();
            rs.next();
            discount = rs.getShort("skidka");
            while (rs.next()) {
                ProducrDao producrDao = new ProducrDao();
                Product product = producrDao.findID(rs.getLong("id_product"));
                Integer count = rs.getInt("count");
                Double orderPrice = rs.getDouble("orderprice");

                ListProducts listProducts = new ListProducts(product,count,orderPrice,Double.valueOf(discount));
                listProductsList.add(listProducts);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Order order = new Order(dataStart, person, discount, statusOrder,listProductsList);

        return order;
    }

}
