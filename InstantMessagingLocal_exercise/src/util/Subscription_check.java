package util;

/**
 *
 * @author juanluis
 */

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Subscription_check {
  
  public enum Result { OKAY, NO_TOPIC, NO_SUBSCRIPTION };
  
  public Topic topic;
  public Result result;
  
}
