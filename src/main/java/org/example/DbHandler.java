package org.example;

import java.sql.*;

public class DbHandler {
    public void DbHandler (){
    }
    Connection connection;
    private static int productAmount;
    private static int forStoreId = 1;
    public void Connect () {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/storedb", "root", "1234");
            connection.setAutoCommit(false);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addTypes (){
        try {
            Statement statement = connection.createStatement();

            statement.addBatch("INSERT INTO type (TYPE) VALUES ('private')");
            statement.addBatch("INSERT INTO type (TYPE) VALUES ('suspension')");
            statement.addBatch("INSERT INTO type (TYPE) VALUES ('congestive')");
            statement.addBatch("INSERT INTO type (TYPE) VALUES ('tubers')");
            statement.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addProducts(int productCount){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO product(name, type) VALUES (?, ?)");
            for(int i = 0; i < productCount; i++){
                ProductDTO productDTo = new ProductDTO();
                ProductDTORandomaizer productDTORandomaizer= new ProductDTORandomaizer();
                productDTo = productDTORandomaizer.createDTO();
                preparedStatement.setString(1, productDTo.getName());
                preparedStatement.setInt(2, productDTo.getType());
                preparedStatement.execute();
                connection.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        productAmount = productCount;
    }
    public void addStore(String storeName, String storeAddress){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO store (name, adress) VALUES (?,?)");
            preparedStatement.setString(1, storeName);
            preparedStatement.setString(2, storeAddress);
            preparedStatement.execute();
            connection.commit();

            addProductsToStore(forStoreId);
            forStoreId++;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public  void addProductsToStore (int storeId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO store_has_products (idstore, idproducts) VALUES (?,?)");
            int amountOfInsertProducts = (int)(1 + Math.random()*(productAmount-1));
            for (int i = 1; i <= amountOfInsertProducts; i++){
                preparedStatement.setInt(1, storeId);
                preparedStatement.setInt(2,(int)(1 + Math.random()*(productAmount-1)));
                preparedStatement.execute();
                connection.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchStoreWithTheMostTypes(String typeOfProduct){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT adress  from (select  adress, count(t.type) as c from store left join store_has_products shp on store.idStore = shp.idStore left join product p on p.idProduct = shp.idProducts left join type t on t.idType = p.type where t.type = ? group by adress)s  order by c desc limit 1;");
            preparedStatement.setString(1,typeOfProduct);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){

                String name = resultSet.getString("adress");

                System.out.println(name);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*public void clearTables() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("TRUNCATE TABLE ");
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
}
