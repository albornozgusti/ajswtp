package com.example.ajswtp.connectordb;

import java.sql.*;


public class MysqlConnector {

    public static void main(String[] args) throws SQLException {
        Connection connection = connectToMysql();
        executeBasicStatement(connection);
        executePreparedStatement(connection, "ar");
    }

    public static Connection connectToMysql(){
        //algoritmo basico para conectarse a una base de datos
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/world";
            connection = DriverManager.getConnection(url,"admin","admin");
            System.out.println("Conectado exitosamente a la BD");
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        return connection;
    }

    public static void executeBasicStatement(Connection connection) throws SQLException {
        //creamos Statement para ejecutar querys
        //creamos ResultSet para manejar los resultados del Statement
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT code, name, continent FROM country");

            while(resultSet.next()){
                String code = resultSet.getString("code");
                String name = resultSet.getString("name");
                String continent = resultSet.getString("continent");
                System.out.println("Codigo: " + code + " Pais: " + name + " Continente: " + continent);
            }

            //al terminar de manejar los datos se cierra
            st.close();
            resultSet.close();
        } catch (Exception e) {
            System.out.println("Error en al ejecutar Statement: " + e);
        }
    }

    public static void executePreparedStatement(Connection connection, String condition) throws SQLException {
        String query = "SELECT code, name, continent FROM country where name like ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%"+condition+"%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                String code = resultSet.getString("code");
                String name = resultSet.getString("name");
                String continent = resultSet.getString("continent");
                System.out.println("Codigo: " + code + " Pais: " + name + " Continente: " + continent);
            }
            resultSet.close();
            ps.close();
        }catch (Exception e){
            System.out.println("Error procesando Prepared Statement: " + e);
        }

    }


}
