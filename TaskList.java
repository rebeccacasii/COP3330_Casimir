import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.nio.file.Paths;
import java.util.Scanner;
import java.lang.String;

public class TaskList
{
    ArrayList<TaskItem>tasks=new ArrayList<>();
    int runningT = 0;

    public int getTaskIndex(TaskItem task)
    {
        return tasks.indexOf(task);
    }
//------------------------------------------------------------------------------------------------------------

    public void addTask(TaskItem task)
    {
        tasks.add(task);
        runningT++;
    }
//------------------------------------------------------------------------------------------------------------

    public TaskItem getTask(int index)
    {
        return tasks.get(index);
    }
//------------------------------------------------------------------------------------------------------------

    public void editTask(int index, String newTitle, String newDescription, String newDate)
    {
        if(index < 0||index>runningT)
        {
            throw new IndexOutOfBoundsException();
        }
        TaskItem editedTask= getTask(index);
        editedTask.setTitle(newTitle);
        editedTask.setDescription(newDescription);
        editedTask.DueDate(newDate);
    }
//------------------------------------------------------------------------------------------------------------

    public void deleteTask(int index)
    {
        if(index < 0||index >runningT){
            throw new IndexOutOfBoundsException("WARNING: task cannot be completed");
        }

        tasks.remove(index);
        runningT--;
    }
//------------------------------------------------------------------------------------------------------------

    public void marksTask(int index)
    {
        if(index<0 || index >runningT)
        {
            throw new IndexOutOfBoundsException("WARNING: Action cannot be completed");
        }
        getTask(index).completed=true;
    }
    //------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------
    public void unmarkTask(int index)
    {
        if(index<0 || index >runningT)
        {
            throw new IndexOutOfBoundsException("WARNING: Action cannot be completed");
        }
        getTask(index).completed = false;
    }
//------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------

    public void loadList(String fileName)
            throws IOException
    {
        String Title;
        String Description;
        String DueDate;
        try (Scanner file = new Scanner(Paths.get(fileName)))
        {
            while(file.hasNext())
            {
                TaskItem proTask = new TaskItem();

                String proTaskComplete =file.nextLine();
                proTask.completed = proTaskComplete.contains("✓");

                Title = file.nextLine();
                Description = file.nextLine();
                DueDate = file.nextLine();

                proTask.DueDate(DueDate);
                proTask.setTitle(Title);
                proTask.setDescription(Description);

                addTask(proTask);
            }
        }

    }
    //------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------
    public void saveList(String fileName)throws FileNotFoundException
    {
        Formatter filler = new Formatter(fileName);
        for(int i =0; i < runningT; i++)
        {
            TaskItem task = getTask(i);
            filler.format("%s%n%d) %n [%s] %n%s%n%s%n",task.taskComplete()
                    ,i,task.getDueDate(), task.getTitle(),task.getDescription());
        }
        filler.close();
    }

}
