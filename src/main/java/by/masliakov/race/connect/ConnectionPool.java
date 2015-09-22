package by.masliakov.race.connect;

import by.masliakov.race.exception.TechnicalException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by mrstark on 21.9.15.
 */
public final class ConnectionPool {
    private BlockingQueue<Connection> connections;

    private static ConnectionPool instance = null;
    private static final int SIZE_POOL = 5;
    private static int curentSize = 1;
    private static AtomicBoolean closeConnections = new AtomicBoolean(false);
    private static AtomicBoolean instanceCreated = new AtomicBoolean(false);
    private static Lock lock = new ReentrantLock();

    private ConnectionPool() throws TechnicalException {

        connections = new LinkedBlockingQueue<Connection>(SIZE_POOL);
        try {
            connections.add(new ConnectorDB().getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ConnectionPool getInstance() throws TechnicalException {

        if (!closeConnections.get()) {
            if (!instanceCreated.get()) {

                try {

                    lock.lock();

                    if (!instanceCreated.get() && !closeConnections.get()) {
                        instance = new ConnectionPool();
                        instanceCreated.set(true);

                    }

                } finally {
                    lock.unlock();
                }

            }
        } else {
            throw new TechnicalException();
        }

        return instance;

    }

    /**
     * @return
     * @throws TechnicalException
     */
    public Connection getConnection() throws TechnicalException {

        Connection connection = null;

        try {

            lock.lock();

            if (curentSize < SIZE_POOL) {

                connection = connections.poll(100, TimeUnit.MILLISECONDS);
                if (connection == null) {

                    connections.add(new ConnectorDB().getConnection());
                    curentSize++;
                    System.out.println(curentSize);
                    connection = connections.poll();

                }

            } else {

                throw new TechnicalException();

            }

        } catch (InterruptedException e) {

            throw new TechnicalException(e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            lock.unlock();

        }

        return connection;

    }

    public void releaseConnection(Connection connection) {

        connections.add(connection);

    }

    public void closeAllConnections() throws TechnicalException {

        closeConnections.set(true);

        try {

            Thread.sleep(5000);

        } catch (InterruptedException e1) {

            e1.printStackTrace();
        }

        for (int i = 0; i < curentSize; i++) {

            try {

                Connection connection = connections.take();
                connection.close();

                System.out.println(connection + " closed!");

            } catch (InterruptedException | SQLException e) {

                throw new TechnicalException(e.getMessage());

            }
        }

        System.out.println("All connections closed!");

    }
}
