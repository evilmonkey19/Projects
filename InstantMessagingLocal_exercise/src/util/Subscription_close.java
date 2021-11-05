package util;

/**
 *
 * @author juanluis
 */

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Subscription_close {
  
  public enum Cause { PUBLISHER, SUBSCRIBER };
  
  public Topic topic;
  public Cause cause;
  
}
