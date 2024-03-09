package com.demo.notificationconsumer.repository;

import com.demo.notificationconsumer.entity.Notification;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends CouchbaseRepository<Notification, Long> {
}
