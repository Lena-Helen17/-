package com.moshkova.elena.files.read_and_writer_file.BD.Dao;

import com.moshkova.elena.files.read_and_writer_file.BD.ConnectionManadger;
import com.moshkova.elena.models.Product;

import java.sql.*;
import java.util.Collection;

public class ProducrDao {
    private static final String FIND_ALL_QUERY = "SELECT * FROM price_list";
    private static final String FIND_ID_QUERY = "SELECT * FROM price_list WHERE id = ?";
    private static final String INSERT_QUERY = "UPDATE price_list SET balance = ? WHERE id = ?";

    public Collection<Product> pindAll (Collection<Product> priceList) {

        try (Connection collection = ConnectionManadger.getConnection();
             Statement st = collection.createStatement();
             ResultSet resultSet = st.executeQuery(FIND_ALL_QUERY);
        ){
            while (resultSet.next()) {
               Product product = resultSetToProduct(resultSet);
               priceList.add(product);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return priceList;
    }

    public Product findID (Long ID) {
        Product product = null;

        try (Connection collection = ConnectionManadger.getConnection();
             PreparedStatement st = collection.prepareStatement(FIND_ID_QUERY);
        ){
            st.setLong(1, ID);
            ResultSet resultSet = st.executeQuery();
            resultSet.next();
            product = resultSetToProduct(resultSet);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return product;
    }


    public  Integer save(Long ID, Integer balans) {
        try (Connection collection = ConnectionManadger.getConnection();
             PreparedStatement st = collection.prepareStatement(INSERT_QUERY);
             ){
            st.setLong(2, ID);
            st.setInt(1,balans);

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;

    }

    public Product resultSetToProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getLong("id"));
        product.setName(resultSet.getString("nameproduct"));
        product.setPrice(resultSet.getDouble("price"));
        product.setColor(resultSet.getString("color"));
        product.setBalance(resultSet.getInt("balance"));

        return product;
    }


}
