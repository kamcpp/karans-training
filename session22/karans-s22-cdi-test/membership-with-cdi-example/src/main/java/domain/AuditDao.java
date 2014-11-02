package domain;

import java.util.Date;
import java.util.UUID;

public interface AuditDao {

    void add(String description);

    void add(UUID id, String description, Date date);
}
