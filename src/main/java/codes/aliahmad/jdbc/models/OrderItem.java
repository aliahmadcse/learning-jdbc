package codes.aliahmad.jdbc.models;

import codes.aliahmad.jdbc.util.DataTransferObject;

public class OrderItem implements DataTransferObject
{
  private long id;
  private Order order;
  private Product product;
  private int quantity;

  @Override
  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public Order getOrder()
  {
    return order;
  }

  public void setOrder(Order order)
  {
    this.order = order;
  }

  public Product getProduct()
  {
    return product;
  }

  public void setProduct(Product product)
  {
    this.product = product;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public void setQuantity(int quantity)
  {
    this.quantity = quantity;
  }

  @Override
  public String toString()
  {
    return "OrderItem{" +
            "id=" + id +
            ", order=" + order +
            ", product=" + product +
            ", quantity=" + quantity +
            '}';
  }
}
