package com.moshkova.elena.files.read_and_writer_file.BD.Dao;

import com.moshkova.elena.files.read_and_writer_file.BD.ConnectionManadger;

import java.sql.*;

public class ListProductsDao {

    private static final String INSERT_QUERY = "INSERT INTO ListProducts (id_product,count,skidka,orderPrice)  VALUES (?, ?, ?,?);";
    private static final String COPY_QUERY = "INSERT INTO ListProductsOrder (id_product,count,skidka,orderPrice,id_order)  VALUES (?, ?, ?,?,?);";
    private static final  String DELETE_QUERY = "DELETE FROM ListProducts WHERE id_product = ?";
    private static final  String DELETE2_QUERY = "DELETE FROM ListProductsOrder WHERE id_product = ? AND id_order = ?";
    private static final  String DELETEALL_QUERY = "TRUNCATE TABLE listproducts RESTART IDENTITY";
    private static final  String APDETE_QUERY = "UPDATE ListProducts SET count = ? , orderPrice  = ? WHERE id_product = ?";
    private static final  String APDETE2_QUERY = "UPDATE ListProductsOrder  SET count = ? , orderPrice  = ? WHERE id_product = ? AND id_order = ?";
    private static final String COUNT_STROC = "SELECT COUNT(*) FROM ListProducts";
    private  static final String RETUN_QUERY = "SELECT * FROM ListProducts WHERE id = ? ";

    public Integer save(Long ID, Integer count, Integer skidca, Double orderPrice) {
        try (Connection collection = ConnectionManadger.getConnection();
             PreparedStatement st = collection.prepareStatement(INSERT_QUERY);
        ){
            st.setLong(1, ID);
            st.setInt(2,count);
            st.setInt(3,skidca);
            st.setDouble(4,orderPrice);


            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка coхранения в ListProducts");
            e.printStackTrace();
        }
        return count;

    }

    public  Integer copy(Integer nomer) {
        try (Connection collection = ConnectionManadger.getConnection();
             PreparedStatement st = collection.prepareStatement(COPY_QUERY);
             Connection collection2 = ConnectionManadger.getConnection();
             PreparedStatement st2 = collection2.prepareStatement(RETUN_QUERY);
        ) {
            for (int i = 1; i < this.countStroc()+1; i++) {

                st2.setInt(1,i);
                ResultSet resultSet = st2.executeQuery();
                resultSet.next();
                st.setLong(1, resultSet.getLong("id_product"));
                st.setInt(2, resultSet.getInt("count"));
                st.setInt(3, resultSet.getInt("skidka"));
                st.setDouble(4, resultSet.getDouble("orderPrice"));
                st.setInt(5, nomer);


                st.executeUpdate();
            }
            } catch(SQLException e){
                System.out.println("Ошибка");
                e.printStackTrace();
            }
            return 1;

    }

     public Integer countStroc() {
        Integer contStrok =0;
        try (Connection collection = ConnectionManadger.getConnection();
             Statement st = collection.createStatement();
             ResultSet resultSet = st.executeQuery(COUNT_STROC);
        ){
            resultSet.next();
            contStrok = resultSet.getInt(1);


        } catch (SQLException throwables) {
            System.out.println("Ge");
        }
        return contStrok;

    }

    public  Integer delete (Long ID) {
        try (Connection collection = ConnectionManadger.getConnection();
             PreparedStatement st = collection.prepareStatement(DELETE_QUERY);
        ){
            st.setLong(1, ID);

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;

    }

    public  Integer delete2 (Long ID, Integer idOr) {
        try (Connection collection = ConnectionManadger.getConnection();
             PreparedStatement st = collection.prepareStatement(DELETE2_QUERY);
        ){
            st.setLong(1, ID);
            st.setInt(2, idOr);

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;

    }

    public  Integer deleteAll () {
        try (Connection collection = ConnectionManadger.getConnection();
             PreparedStatement st = collection.prepareStatement(DELETEALL_QUERY);
        ){

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;

    }

    public  Integer update(Long ID, Integer count, Double orderPrice) {
        try (Connection collection = ConnectionManadger.getConnection();
             PreparedStatement st = collection.prepareStatement(APDETE_QUERY);
        ){
            st.setLong(3, ID);
            st.setInt(1,count);
            st.setDouble(2,orderPrice);


            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;

    }

    public  Integer update2(Long ID, Integer count, Double orderPrice, Integer idOrder) {
        try (Connection collection = ConnectionManadger.getConnection();
             PreparedStatement st = collection.prepareStatement(APDETE2_QUERY);
        ){
            st.setLong(3, ID);
            st.setInt(1,count);
            st.setDouble(2,orderPrice);
            st.setInt(4,idOrder);


            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;

    }



}

