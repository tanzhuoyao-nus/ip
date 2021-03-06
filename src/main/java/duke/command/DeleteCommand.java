package duke.command;

import duke.Storage;
import duke.TaskList;

/**
 * DeleteCommand class handles instructions when user wants to delete task.
 */

public class DeleteCommand extends Command {
    public DeleteCommand(String command, TaskList list, Storage storage) {
        super(command, list, storage);
    }

    /**
     * Deletes specified task.
     * @param command User input
     * @param list TaskList object containing all tasks
     * @param storage Storage object that reads and writes to duke.txt
     * @return A response with deleted task
     */
    @Override
    public String execute(String command, TaskList list, Storage storage) {
        String horizontalLine = "____________________________________\n";
        String index = command.substring(7);
        try {
            int number = Integer.parseInt(index);
            Boolean isNumberOutOfRange = number <= 0 || number > list.getList().size();
            if (isNumberOutOfRange) {
                return Warnings.inputOutOfRangeWarning();
            } else {
                String taskMessage = list.getList().get(number - 1).toString();
                list.deleteTask(number);
                storage.writeData(list.getList());
                return horizontalLine + "Task deleted liao: \n" + taskMessage + "\n"
                        + "You got " + list.getList().size() + " tasks left. \n" + horizontalLine;
            }
        } catch (NumberFormatException ex) {
            return Warnings.invalidInputWarning();
        }
    }
}
