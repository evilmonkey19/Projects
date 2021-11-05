package entity;

import entity.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-10-20T13:07:16")
@StaticMetamodel(TheOrder.class)
public class TheOrder_ { 

    public static volatile SingularAttribute<TheOrder, String> description;
    public static volatile SingularAttribute<TheOrder, Integer> id;
    public static volatile SingularAttribute<TheOrder, Customer> customer;

}