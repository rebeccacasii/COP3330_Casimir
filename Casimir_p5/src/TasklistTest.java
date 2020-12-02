import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TasklistTest
{
    TaskList tasks = new TaskList();
    TaskItem tasking = new TaskItem();

    @Test
    public void newTaskListIsEmpty()
    {
        assertEquals(0,tasks.runningT);
    }

    @Test
    public void addingTaskItemsIncreasesSize()
    {
        tasking.setTitle("SET");
        tasking.setDescription("DESC");
        tasking.DueDate("2020-11-17");
        tasks.addTask(tasking);

        tasking.setTitle("SET2");
        tasking.setDescription("DESC2");
        tasking.DueDate("2020-11-18");
        tasks.addTask(tasking);

        assertEquals(2, tasks.runningT);
    }

    @Test
    public void completingTaskItemChangesStatus()
    {
        tasks.addTask(tasking);
        tasks.unmarkTask(0);
        assertTrue(!tasking.completed);
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex()
    {
        assertThrows(
                IndexOutOfBoundsException.class, ()-> {
                    tasks.addTask(tasking);
                    tasks.unmarkTask(2);
                    assertTrue(!tasking.completed);
                }
        );
    }

    @Test
    public void editingTaskItemChangesValues()
    {
        tasks.addTask(tasking);
        tasks.editTask(0,"NEW SET", "NEW DESC","2020-11-26");
        assertEquals("NEW SET", tasking.getTitle() );
        assertEquals("NEW DESC", tasking.getDescription());
       assertEquals("2020-11-26", tasking.getDueDate());
    }

    @Test
    public void editingTaskItemDescriptionChangesValue()
    {
        tasks.addTask(tasking);
        tasks.editTask(0,"NEW SET", "NEW DESC","2020-11-26");
        assertEquals("NEW DESC", tasking.getDescription());
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex()
    {
        assertThrows(
                IndexOutOfBoundsException.class,()-> {
                    tasks.addTask(tasking);
                    tasks.editTask(2, "NEW SET", "NEW DESC", "2020-11-26");
                    assertEquals("NEW DESC", tasking.getDescription());
                }
        );
    }

    @Test
    public void editingTaskItemDueDateChangesValue()
    {
        tasks.addTask(tasking);
        tasks.editTask(0,"NEW SET", "NEW DESC","2020-11-26");
        assertEquals("2020-11-26", tasking.getDueDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex()
    {
        assertThrows(
                IndexOutOfBoundsException.class,()-> {
                    tasks.addTask(tasking);
                    tasks.editTask(2, "NEW SET", "NEW DESC", "2020-11-26");
                    assertEquals("2020-11-26", tasking.getDueDate());
                }
        );
    }

    @Test
    public void editingTaskItemTitleChangesValue()
    {
        tasks.addTask(tasking);
        tasks.editTask(0,"NEW SET", "NEW DESC","2020-11-26");
        assertEquals("NEW SET", tasking.getTitle());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex()
    {
        assertThrows(
                IndexOutOfBoundsException.class, ()->{
        tasks.addTask(tasking);
        tasks.editTask(2,"NEW SET", "NEW DESC","2020-11-26");
        assertEquals("NEW SET", tasking.getTitle());
        }
        );
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex()
    {
        tasking.setDescription("DESC");
        tasks.addTask(tasking);
        assertEquals(tasking.getDescription(),tasks.getTask(2).getDescription());
        //assertEquals("NEW SET", tasking.getTitle());
    }
    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex()
    {
        tasking.setDescription("DESC");
        tasks.addTask(tasking);
        assertEquals(tasking.getDescription(),tasks.getTask(0).getDescription());
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex()
    {
        tasking.DueDate("2020-11-17");
        tasks.addTask(tasking);
        assertEquals("2020-11-17",tasks.getTask(2).getDueDate());
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex()
    {
        tasking.DueDate("2020-11-17");
        tasks.addTask(tasking);
        assertEquals("2020-11-17",tasks.getTask(0).getDueDate());
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex()
    {
        tasking.setTitle("SET");
        tasks.addTask(tasking);
        assertEquals("SET",tasks.getTask(2).getTitle());
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex()
    {
        tasking.setTitle("SET");
        tasks.addTask(tasking);
        assertEquals("SET",tasks.getTask(0).getTitle());
    }


    @Test
    public void removingTaskItemsDecreasesSize()
    {
        tasks.addTask(tasking);
        tasks.deleteTask(0);
        assertEquals(0,tasks.runningT);
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex()
    {
        assertThrows(
                IndexOutOfBoundsException.class, ()-> {
                    tasks.addTask(tasking);
                    tasks.deleteTask(1);
                    assertEquals(0, tasks.runningT);
                }
        );
    }

    @Test
    public void savedTaskListCanBeLoaded() throws IOException
    {
        assertDoesNotThrow(
                ()-> {
                    tasks.loadList("tasks.txt");
                }
        );
    }

    @Test
    public void uncompletingTaskItemChangesStatus()
    {
        tasks.addTask(tasking);
        tasks.unmarkTask(0);
        assertTrue(!tasking.completed);
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex()
    {
        assertThrows(
                IndexOutOfBoundsException.class, ()-> {
                    tasks.addTask(tasking);
                    tasks.unmarkTask(2);
                    assertTrue(!tasking.completed);
                }
        );
    }

}
