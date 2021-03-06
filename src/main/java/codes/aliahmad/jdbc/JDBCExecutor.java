package codes.aliahmad.jdbc;

import codes.aliahmad.jdbc.dao.CustomerDAO;
import codes.aliahmad.jdbc.dao.OrderDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCExecutor
{
  public static void main(String... args)
  {
    DatabaseConnectionManager databaseConnectionManager = new DatabaseConnectionManager(
            "localhost", "hplussport", "postgres", "password");

    try
    {
      Connection connection = databaseConnectionManager.getConnection();
//      CustomerDAO customerDAO = new CustomerDAO(connection);
//      customer.setId(10000);
//      customer.setFirstName("Zain");
//      customer.setLastName("Ahmad");
//      customer.setEmail("ali@gmail.com");
//      customer.setPhone("9230232323");
//      customer.setAddress("xyz");
//      customer.setCity("New York");
//      customer.setState("Washington DC");
//      customer.setZipCode("12345");
//      customerDAO.delete(10000);
//      System.out.println(customerDAO.findById(100));

//      OrderDAO orderDAO = new OrderDAO(connection);
//      System.out.println(orderDAO.findById(1002));

      OrderDAO orderDAO = new OrderDAO(connection);
      System.out.println(orderDAO.getOrdersForCustomer(789));
    }
    catch (SQLException sqlException)
    {
      sqlException.printStackTrace();
    }
  }
}
