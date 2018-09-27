package lt.bt.messager.messanger.dto;

import lt.bt.messager.messanger.entity.MessageEntity;

public class Message {
    private String message;

    private String receiver;

    private String sender;

<<<<<<< Updated upstream
=======
    private Long  channelId;

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

>>>>>>> Stashed changes
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Message() {
    }



}
