package br.com.senacrs.DAO;

import br.com.senacrs.TO.Address;
import br.com.senacrs.TO.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    
    private static final String INSERT_QUERY = "INSERT INTO person (name, age, sex) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM person";
    private static final String DELETE_QUERY = "DELETE FROM person WHERE id = ?";
     private static final String SELECT_BY_PERSON_ID_QUERY = "SELECT * FROM address WHERE person_id = ?";
    
    
    public void salvar(Person person) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, person.getName());
            preparedStatement.setDate(2, java.sql.Date.valueOf(person.getAge()));
            preparedStatement.setString(3, person.getSex());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public List<Person> listar() {
        List<Person> pessoas = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("name");
                LocalDate idade = resultSet.getDate("age").toLocalDate();
                String sexo = resultSet.getString("sex");
                List<Address> addresses = listarEnderecosPorPessoa(id);
                Person person = new Person(id, nome, idade, sexo);
                person.setAddress(addresses);
                pessoas.add(person);
            }
        } catch (SQLException e) {          
        }
        return pessoas;
    }
    
    private List<Address> listarEnderecosPorPessoa(int personId) {
        List<Address> enderecos = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_PERSON_ID_QUERY)) {
            preparedStatement.setInt(1, personId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String estado = resultSet.getString("state");
                    String cidade = resultSet.getString("city");
                    String logradouro = resultSet.getString("publicPlace");
                    int numero = resultSet.getInt("num");
                    int cep = resultSet.getInt("zipCode");
                    enderecos.add(new Address(id, estado, cidade, logradouro, numero, cep));
                }
            }
        } catch (SQLException e) {           
        }
        return enderecos;
    }
    
    
    public void remover(int id) {
        removerEnderecosDaPessoa(id);
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {            
        }
    }
    
    private void removerEnderecosDaPessoa(int personId) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM address WHERE person_id = ?")) {
            preparedStatement.setInt(1, personId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {          
        }
    }
}