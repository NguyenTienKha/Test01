/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen Tien Kha ToyFacade = ToyDAO CRUD = create read update delete
 */
public class ToyFacade {

    public List<Toy> select() throws SQLException {
        List<Toy> list = null;
        //Tao connection de ket noi vào DBMS
        Connection con = DBContext.getConnection();
        //Tao doi tuong statement
        Statement stm = con.createStatement();
        //Thuc thi lenh SELECT
        ResultSet rs = stm.executeQuery("select * from toy");
        list = new ArrayList<>();
        while (rs.next()) {
            //Doc mau tin hien hanh de vao doi tuong toy
            Toy toy = new Toy();
            toy.setId(rs.getString("id"));
            toy.setName(rs.getString("name"));
            toy.setPrice(rs.getDouble("price"));
            toy.setExpDate(rs.getDate("expDate"));
            toy.setBrand(rs.getString("brand"));
            //Them toy vao list
            list.add(toy);
        }
        con.close();
        return list;
    }

    public Toy select(String id) throws SQLException {
        //Tao connection de ket noi vào DBMS
        Connection con = DBContext.getConnection();
        //Tao doi tuong statement
        PreparedStatement stm = con.prepareStatement("select * from Toy where id =?");
        //Truyen gia tri cho cac tham so
        stm.setString(1, id);

        //Thuc thi lenh Select
        ResultSet rs = stm.executeQuery();
        Toy toy = null;
        if (rs.next()) {
            //Doc mau tin hien hanh de vao doi tuong toy
            toy = new Toy();
            toy.setId(rs.getString("id"));
            toy.setName(rs.getString("name"));
            toy.setPrice(rs.getDouble("price"));
            toy.setExpDate(rs.getDate("expDate"));
            toy.setBrand(rs.getString("brand"));
        }
        con.close();
        return toy;
    }

    public void create(Toy toy) throws SQLException {
        //Tao connection de ket noi vào DBMS
        Connection con = DBContext.getConnection();
        //Tao doi tuong statement
        PreparedStatement stm = con.prepareStatement("insert into Toy values(?,?,?,?,?)");
        //Truyen gia tri cho cac tham so
        stm.setString(1, toy.getId());
        stm.setString(2, toy.getName());
        stm.setDouble(3, toy.getPrice());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(4, sdf.format(toy.getExpDate()));
        stm.setString(5, toy.getBrand());
        //Thuc thi lenh INSERT
        int count = stm.executeUpdate();
        con.close();

    }

    public void delete(String id) throws SQLException {
        //delete from Toy where id =?
        //Tao connection de ket noi vào DBMS
        Connection con = DBContext.getConnection();
        //Tao doi tuong statement
        PreparedStatement stm = con.prepareStatement("delete from Toy where id =?");
        //Truyen gia tri cho cac tham so
        stm.setString(1, id);

        //Thuc thi lenh Delete
        int count = stm.executeUpdate();
        con.close();
    }

    public void update(Toy toy) throws SQLException {
        //Tao connection de ket noi vào DBMS
        Connection con = DBContext.getConnection();
        //Tao doi tuong statement
        PreparedStatement stm = con.prepareStatement("update Toy set name=?,price=?,expDate=?,brand=? where id=?");
        //Truyen gia tri cho cac tham so
        stm.setString(1, toy.getName());
        stm.setDouble(2, toy.getPrice());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(3, sdf.format(toy.getExpDate()));
        stm.setString(4, toy.getBrand());
        stm.setString(5, toy.getId());
        //Thuc thi lenh Update
        int count = stm.executeUpdate();
        con.close();

    }

}
