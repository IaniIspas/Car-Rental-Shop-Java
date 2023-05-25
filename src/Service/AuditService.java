package Service;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditService {
    private static final String AUDIT_LOG_FILE = "audit_log.csv";

    public void writeToAuditLog(String actionName) {
        String timestamp = getCurrentTimestamp();

        try (FileWriter writer = new FileWriter(AUDIT_LOG_FILE, true)) {
            writer.append(actionName)
                    .append(",")
                    .append(timestamp)
                    .append("\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCurrentTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}




