package com.domowka.api.dao.transport;

import com.domowka.api.model.Transport;

public interface TransportDao {
    int insertTransport();
    Iterable<Transport> getAllTransports();
}
