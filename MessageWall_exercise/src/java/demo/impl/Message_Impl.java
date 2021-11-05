package demo.impl;

import demo.spec.Message;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Message_Impl implements Message, java.io.Serializable {

  private String user, message;

  @Override
  public String getContent() {
    return message;
  }

  @Override
  public String getOwner() {
    return user;
  }
}
