package codes.aliahmad.jdbc;

import codes.aliahmad.jdbc.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerDAO extends DataAccessObject<Customer>
{
  private static final String INSERT = "INSERT INTO customer (first_name, last_name, email," +
          "phone, address, city, state, zipcode) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
  private static final String GET_ONE = "SELECT customer_id, first_name, last_name, email," +
          "phone, address, city, state, zipcode FROM customer WHERE customer_id = ?";

  private static final String UPDATE = "UPDATE customer SET first_name = ?, last_name = ?, email = ?," +
          "phone = ?, address = ?, city = ?, state = ?, zipcode = ? WHERE customer_id = ?";

  private static final String DELETE = "DELETE FROM customer WHERE customer_id = ?";

  public CustomerDAO(Connection connection)
  {
    super(connection);
  }

  @Override
  public Customer findById(long id)
  {
    Customer customer = new Customer();
    try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ONE);)
    {
      preparedStatement.setLong(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next())
      {
        customer.setId(resultSet.getLong("customer_id"));
        customer.setFirstName(resultSet.getString("first_name"));
        customer.setLastName(resultSet.getString("last_name"));
        customer.setEmail(resultSet.getString("email"));
        customer.setPhone(resultSet.getString("phone"));
        customer.setAddress(resultSet.getString("address"));
        customer.setCity(resultSet.getString("city"));
        customer.setState(resultSet.getString("state"));
        customer.setZipCode(resultSet.getString("zipcode"));
      }
      return customer;
    }
    catch (SQLException sqlException)
    {
      sqlException.printStackTrace();
      throw new RuntimeException(sqlException);
    }
  }

  @Override
  public List<Customer> findAll()
  {
    return null;
  }

  @Override
  public Customer update(Customer dataTransferObject)
  {
    Customer customer = null;
    try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);)
    {
      preparedStatement.setString(1, dataTransferObject.getFirstName());
      preparedStatement.setString(2, dataTransferObject.getLastName());
      preparedStatement.setString(3, dataTransferObject.getEmail());
      preparedStatement.setString(4, dataTransferObject.getPhone());
      preparedStatement.setString(5, dataTransferObject.getAddress());
      preparedStatement.setString(6, dataTransferObject.getCity());
      preparedStatement.setString(7, dataTransferObject.getState());
      preparedStatement.setString(8, dataTransferObject.getZipCode());
      preparedStatement.setLong(9, dataTransferObject.getId());
      preparedStatement.execute();

      customer = findById(dataTransferObject.getId());
      return customer;
    }
    catch (SQLException sqlException)
    {
      sqlException.printStackTrace();
      throw new RuntimeException(sqlException);
    }
  }

  @Override
  public Customer create(Customer dataTransferObject)
  {
    try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT);)
    {
      preparedStatement.setString(1, dataTransferObject.getFirstName());
      preparedStatement.setString(2, dataTransferObject.getLastName());
      preparedStatement.setString(3, dataTransferObject.getEmail());
      preparedStatement.setString(4, dataTransferObject.getPhone());
      preparedStatement.setString(5, dataTransferObject.getAddress());
      preparedStatement.setString(6, dataTransferObject.getCity());
      preparedStatement.setString(7, dataTransferObject.getState());
      preparedStatement.setString(8, dataTransferObject.getZipCode());
      preparedStatement.execute();
      int id = getLastValue(CUSTOMER_SEQUENCE);
      return findById(id);
    }
    catch (SQLException sqlException)
    {
      sqlException.printStackTrace();
      throw new RuntimeException(sqlException);
    }
  }

  @Override
  public void delete(long id)
  {
    try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE))
    {
      preparedStatement.setLong(1, id);
      preparedStatement.execute();
    }
    catch (SQLException sqlException)
    {
      sqlException.printStackTrace();
      throw new RuntimeException(sqlException);
    }
  }
}
