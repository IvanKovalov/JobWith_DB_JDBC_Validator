package org.example;

import org.example.DTO.ProductDTO;
import org.example.DTO.StoreDTO;
import org.example.DTO.TypeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.sql.*;

public class DbHandler {
    public void DbHandler (){

    }
    Connection connection;
    private  int productAmount;
    private  int forStoreId = 1;

    Logger logger = LoggerFactory.getLogger(DbHandler.class);

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/storedb", "root", "1234");
            connection.setAutoCommit(false);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addTypes (TypeDTO typeDTO, boolean checked){
        if(checked) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO type (TYPE) VALUES (?)");
                preparedStatement.setString(1, typeDTO.getType());
                preparedStatement.execute();
                connection.commit();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }

    }
    public void addProduct(ProductDTO productDTO, boolean checked){
        try {

            if (checked){
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO product(name, type) VALUES (?, ?)");
                preparedStatement.setString(1, productDTO.getName());
                preparedStatement.setInt(2, productDTO.getType());
                preparedStatement.execute();
                connection.commit();
                productAmount ++;
                }

             } catch (SQLException e) {
                throw new RuntimeException(e);
            }

    }
    public void addStore(StoreDTO storeDTO, boolean checked){
        try {
            if(checked) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO store (name, adress) VALUES (?,?)");
                preparedStatement.setString(1, storeDTO.getName());
                preparedStatement.setString(2, storeDTO.getAddress());
                preparedStatement.execute();
                connection.commit();

                addProductsToStore(forStoreId);
                forStoreId++;
            }
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

               logger.info(name);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
