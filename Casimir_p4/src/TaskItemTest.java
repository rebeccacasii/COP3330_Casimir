import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {
    TaskItem tasking = new TaskItem();

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate()
    {
        tasking.date="2020-12-26";
        tasking.checkDate(tasking.date);

    }

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate()
    {
        assertThrows(DateTimeException.class, ()->{
            tasking.DueDate("0");
            tasking.checkDate(tasking.getDueDate());
        });

    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle()
    {
        assertThrows(IllegalArgumentException.class, ()->
        {
            tasking.title="";
            tasking.checkTitle(tasking.title);
        });

    }


    @Test
    public void creatingTaskItemSucceedsWithValidTitle()
    {
            tasking.title="SET";
            tasking.checkTitle(tasking.title);

    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate()
    {
        assertThrows(DateTimeException.class, ()->{
        tasking.date="20-0-0";
        tasking.DueDate(tasking.date);
    });


    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate()
    {
            tasking.date="2020-12-26";
            tasking.DueDate(tasking.date);
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle()
    {
        assertThrows(IllegalArgumentException.class, ()->{
            tasking.title="";
            tasking.setTitle(tasking.title);
        });
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle()
    {
        tasking.title = "SET";
        tasking.setTitle(tasking.title);

    }
}
