package au.id.wolfe.logmiller.core;

import org.apache.commons.lang.builder.*;

/**
 * Result of the log file index operation
 */
public class IndexingResult {

    private boolean success = false;
    private long rowsIndexed = 0;
    private long timeTaken = 0;

    public IndexingResult() {
    }

    public IndexingResult(boolean success, long rowsIndexed, long timeTaken) {
        this.success = success;
        this.rowsIndexed = rowsIndexed;
        this.timeTaken = timeTaken;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public long getRowsIndexed() {
        return rowsIndexed;
    }

    public void setRowsIndexed(long rowsIndexed) {
        this.rowsIndexed = rowsIndexed;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).
                append("success", success).
                append("rowsIndexed", rowsIndexed).
                append("timeTaken", timeTaken).
                toString();
    }
}
