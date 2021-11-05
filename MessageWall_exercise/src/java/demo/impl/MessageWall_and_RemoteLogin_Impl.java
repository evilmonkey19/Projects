package demo.impl;

import demo.spec.Message;
import demo.spec.MessageWall;
import demo.spec.RemoteLogin;
import demo.spec.UserAccess;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class MessageWall_and_RemoteLogin_Impl implements RemoteLogin, MessageWall {

    private List<Message> messages = new ArrayList();

    @Override
    public UserAccess connect(String usr, String passwd) {
        // Next version : Check if the user and pswd are correct
        return new UserAccess_Impl(usr, this);
    }

    /* Put new message on the wall */
    @Override
    public void put(String user, String msg) {
        messages.add(new Message_Impl(user, msg));
    }

    /* Delete message from the wall */
    @Override
    public boolean delete(String user, int index) {
        // Check if the user who requests the removal is the the owner
        if (!user.equals(messages.get(index).getOwner()))
            return false;
        messages.remove(index);
        return true;       
    }

    /* Get the last message */
    @Override
    public Message getLast() {
        if (messages.isEmpty())
            return new Message_Impl("Admin", "You can write the first message ;)");
        return messages.get(messages.size()-1);
     }

    @Override
    public int getNumber() {
        return messages.size();
    }

    @Override
    public List<Message> getAllMessages() {
        return messages;
    }

}
