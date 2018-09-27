package lt.bt.messager.messanger.repository;

import lt.bt.messager.messanger.entity.MessageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<MessageEntity, Long> {

    List<MessageEntity> findAllByReceiver(Long receiver);
<<<<<<< Updated upstream
=======

    List<MessageEntity> findAllByChannel(Long channel);
>>>>>>> Stashed changes
}
