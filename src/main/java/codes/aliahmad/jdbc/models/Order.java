package codes.aliahmad.jdbc.models;

import codes.aliahmad.jdbc.util.DataTransferObject;

import java.util.List;

public class Order implements DataTransferObject
{
  private long id;
  private String creationDate;
  private double totalDue;
  private String status;
  private Customer customer;
  private SalesPerson salesPerson;
  private List<OrderItem> orderItemList;

  @Override
  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public String getCreationDate()
  {
    return creationDate;
  }

  public void setCreationDate(String creationDate)
  {
    this.creationDate = creationDate;
  }

  public double getTotalDue()
  {
    return totalDue;
  }

  public void setTotalDue(double totalDue)
  {
    this.totalDue = totalDue;
  }

  public String getStatus()
  {
    return status;
  }

  public void setStatus(String status)
  {
    this.status = status;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public void setCustomer(Customer customer)
  {
    this.customer = customer;
  }

  public SalesPerson getSalesPerson()
  {
    return salesPerson;
  }

  public void setSalesPerson(SalesPerson salesPerson)
  {
    this.salesPerson = salesPerson;
  }

  public List<OrderItem> getOrderItemList()
  {
    return orderItemList;
  }

  public void setOrderItemList(List<OrderItem> orderItemList)
  {
    this.orderItemList = orderItemList;
  }

  @Override
  public String toString()
  {
    return "Order{" +
            "id=" + id +
            ", creationDate='" + creationDate + '\'' +
            ", totalDue=" + totalDue +
            ", status='" + status + '\'' +
            ", customer=" + customer +
            ", salesPerson=" + salesPerson +
            ", orderItemList=" + orderItemList +
            '}';
  }
}
