package topicmanager;

import util.Subscription_check;
import util.Topic;
import util.Topic_check;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import publisher.Publisher;
import publisher.PublisherImpl;
import subscriber.Subscriber;

public class TopicManagerImpl implements TopicManager {
    private Map<Topic, Publisher> topicMap;
    
    public TopicManagerImpl(){
        topicMap = new HashMap<Topic, Publisher>();
    }

    @Override
    // Add new publisher to a topic
    public Publisher addPublisherToTopic(Topic topic) {
        Publisher publisher = new PublisherImpl(topic);
        topicMap.put(topic, publisher);
        return publisher;
    }

    @Override
    public void removePublisherFromTopic(Topic topic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    // Checks if a topic is open or not current available (does not exist or closed)
    public Topic_check isTopic(Topic topic) {
        return new Topic_check(topic, topicMap.containsKey(topic));
    }

    @Override
    // list all topics
    public List<Topic> topics() {
        return new ArrayList(topicMap.keySet());
    }

    @Override
    public Subscription_check subscribe(Topic topic, Subscriber subscriber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Subscription_check unsubscribe(Topic topic, Subscriber subscriber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}