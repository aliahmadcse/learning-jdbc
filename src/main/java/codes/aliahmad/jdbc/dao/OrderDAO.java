package codes.aliahmad.jdbc.dao;

import codes.aliahmad.jdbc.models.Customer;
import codes.aliahmad.jdbc.models.Order;
import codes.aliahmad.jdbc.models.OrderItem;
import codes.aliahmad.jdbc.models.Product;
import codes.aliahmad.jdbc.models.SalesPerson;
import codes.aliahmad.jdbc.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO extends DataAccessObject<Order>
{

  private static final String GET_ONE = "SELECT c.first_name, c.last_name, c.email, o.order_id, " +
          "o.creation_date, o.total_due, o.status, s.first_name, s.last_name, s.email, ol.quantity, " +
          "p.code, p.name, p.size, p.variety, p.price FROM orders o join customer c on " +
          "o.customer_id = c.customer_id join salesperson s on o.salesperson_id = s.salesperson_id " +
          "join order_item ol on o.order_id = ol.order_id join product p on ol.product_id = p.product_id " +
          "where o.order_id = ?";

  public OrderDAO(Connection connection)
  {
    super(connection);
  }

  @Override
  public Order findById(long id)
  {
    Order order = new Order();
    Customer customer = new Customer();
    SalesPerson salesPerson = new SalesPerson();
    try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ONE);)
    {
      preparedStatement.setLong(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      long orderId = 0;
      List<OrderItem> orderItemList = new ArrayList<>();
      while (resultSet.next())
      {
        if (orderId == 0)
        {
          //        customer result set
          customer.setFirstName(resultSet.getString(1));
          customer.setLastName(resultSet.getString(2));
          customer.setEmail(resultSet.getString(3));
          order.setCustomer(customer);

          order.setId(resultSet.getLong(4));
          orderId = order.getId();
          order.setCreationDate(resultSet.getString(5));
          order.setTotalDue(resultSet.getDouble(6));
          order.setStatus(resultSet.getString(7));

//        sales person result set
          salesPerson.setFirstName(resultSet.getString(8));
          salesPerson.setLastName(resultSet.getString(9));
          salesPerson.setEmail(resultSet.getString(10));
          order.setSalesPerson(salesPerson);
        }
        OrderItem orderItem = new OrderItem();
        Product product = new Product();
        orderItem.setQuantity(resultSet.getInt(11));
        product.setCode(resultSet.getString(12));
        product.setName(resultSet.getString(13));
        product.setSize(resultSet.getInt(14));
        product.setVariety(resultSet.getString(15));
        product.setPrice(resultSet.getDouble(16));
        orderItem.setProduct(product);

        orderItemList.add(orderItem);
      }
      order.setOrderItemList(orderItemList);
      return order;
    }
    catch (SQLException sqlException)
    {
      sqlException.printStackTrace();
      throw new RuntimeException(sqlException);
    }
  }

  @Override
  public List<Order> findAll()
  {
    return null;
  }

  @Override
  public Order update(Order dataTransferObject)
  {
    return null;
  }

  @Override
  public Order create(Order dataTransferObject)
  {
    return null;
  }

  @Override
  public void delete(long id)
  {

  }
}
