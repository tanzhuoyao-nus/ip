package duke.command;

import duke.Storage;
import duke.TaskList;

/**
 * Parent Command class.
 */

public class Command {
    protected String command;
    protected TaskList list;
    protected Storage storage;

    /**
     * Command object.
     * @param command Input received
     * @param list List of tasks
     * @param storage Storage object to access duke.ser
     */
    public Command(String command, TaskList list, Storage storage) {
        this.command = command;
        this.list = list;
        this.storage = storage;
    }

    /**
     * Null Command object
     */
    public Command() {
        this.command = null;
        this.list = null;
        this.storage = null;
    }

    /**
     * To be overridden by subclasses.
     * @param command User input
     * @param list TaskList object containing all tasks
     * @param storage Storage object that reads and writes to duke.ser
     */
    public void execute(String command, TaskList list, Storage storage) {
    }

    public boolean isExit() {
        return false;
    }
}
