package br.com.senacrs.DAO;

import br.com.senacrs.TO.Address;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO {
    
    private static final String INSERT_QUERY = "INSERT INTO address (state, city, publicPlace, num, zipCode) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM address";
    private static final String DELETE_QUERY = "DELETE FROM address WHERE id = ?";
    
    
    public void salvar(Address address) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, address.getState());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getPublicPlace());
            preparedStatement.setInt(4, address.getNum());
            preparedStatement.setInt(5, address.getZipCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {         
        }
    }
    
    public List<Address> listar() {
        List<Address> enderecos = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String estado = resultSet.getString("state");
                String cidade = resultSet.getString("city");
                String logradouro = resultSet.getString("publicPlace");
                int numero = resultSet.getInt("num");
                int cep = resultSet.getInt("zipCode");               
                enderecos.add(new Address(id, estado, cidade, logradouro, numero, cep));
            }
        } catch (SQLException e) {           
        }
        return enderecos;
    }

    public void remover(int id) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {           
        }
    }
   
    
}
