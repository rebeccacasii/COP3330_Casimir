import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.time.DateTimeException;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static Scanner input =new Scanner(System.in);

    private static void addTask(TaskList tasks)
    {
        System.out.print("Task Title: ");
        String userTitle = input.nextLine();

        System.out.print("Task Description: ");
        String userDesc = input.nextLine();

        System.out.print("Task Due Date (YYYY-MM-DD): ");
        String userDate = input.nextLine();
        try
        {
            TaskItem task = new TaskItem();
            task.setTitle(userTitle);
            task.setDescription(userDesc);
            task.DueDate(userDate);
            tasks.addTask(task);
        }
        catch(IllegalArgumentException exception)
        {
            System.out.println("WARNING: Title must have one or more characters. Task not Created");
        }
        catch (DateTimeException exception)
        {
            System.out.println("Warning: Invalid due date. Task not created");
        }
        finally
        {
            input.nextLine();
        }

    }
//------------------------------------------------------------------------------------------------------------
    private static void editTask(TaskList tasklist){

        String editTitle;
        String editDesc;
        String editDate;
        int index;
        try{
            if (tasklist.runningT<=0)
            {
                throw new NoSuchFieldException("WARNING Cannont edit");
            }

            System.out.println("Current Tasks");
            System.out.println("-------------------");
            displayTasks(tasklist);
            System.out.print("What task are you trying to edit?");

            index = input.nextInt();
            input.nextLine();


            System.out.print("Enter a new title for task " +index+ " :");
            editTitle = input.nextLine();

            System.out.print("Enter a new description for task "+index+ " :");
            editDesc=input.nextLine();

            System.out.print("Enter a new taskk due date (YYYY-MM-DD) for task "+index+" :");
            editDate = input.nextLine();

            tasklist.editTask(index,editTitle, editDesc,editDate);
        }
        catch(DateTimeException exception)
        {
            System.out.println("WARNING: there are no tasks to edit.");
        }
        catch(IllegalArgumentException exception)
        {
            System.out.println("WARNING: Title must contain characters");
        }
        catch(InputMismatchException exception)
        {
            System.out.println("WARNING: enter the index of task you want to edit as an integer");
        }
        catch(NoSuchFieldException exception)
        {
            System.out.println("WARNING: There are no tasks to edit");
        }
        finally
        {
            input.nextLine();
        }
    }
//------------------------------------------------------------------------------------------------------------

    private static void deleteTask(TaskList tasklist)
    {
        try{
            if(tasklist.runningT <=0)
            {
                throw new NoSuchFieldException("WARNING: Cannot delete");
            }
            System.out.println("Current Tasks");
            System.out.println("-------------------");
            displayTasks(tasklist);
            System.out.print("What tasks would you like to remove?");
            int index = input.nextInt();
            tasklist.deleteTask(index);
        }
        catch(InputMismatchException exception){
            System.out.println("WARNING:enter the index of task you want to remove as an integer");
        }
        catch(IndexOutOfBoundsException exception){
            System.out.println("WARNING: You cant remove the task, invalid");
        }
        catch(NoSuchFieldException exception){
            System.out.println("Warning: no tasks available to remove");
        }
    }
//------------------------------------------------------------------------------------------------------------

    private static void disIncompleTasks(TaskList tasks)
    {
        for(int i = 0; i<tasks.runningT;i++)
        {
            TaskItem currentTask=tasks.getTask(i);
            if(!currentTask.completed)
            {
                int filler = tasks.getTaskIndex(currentTask);
                String title=currentTask.title;
                String description = currentTask.description;
                String Date=currentTask.date;
                System.out.println(filler+") ["+Date+"] "+title+": "+description);
            }
        }
    }
//------------------------------------------------------------------------------------------------------------

    private static void TaskComplete(TaskList tasks)
    {
        try{
            if(tasks.runningT<=0)
            {
                throw new NoSuchFieldException("WARNING: Cannot complete action");
            }

            System.out.println("Uncompleted Tasks");
            System.out.println("-----------------------");
            disIncompleTasks(tasks);

            System.out.println("Which tasks will you mark as complete?");
            int index = input.nextInt();

            input.nextLine();
            tasks.marksTask(index);
            if(tasks.runningT==0)
            {
                throw new NoSuchFieldException("WARNING: Cannot complete action");
            }
        }
        catch(InputMismatchException exception)
        {
            System.out.println("WARNING: you must enter an integer");
        }
        catch(IndexOutOfBoundsException exception )
        {
            System.out.println("WARNING: you can not mark task as complete");
        }
        catch(NoSuchFieldException exception)
        {
            System.out.println("WARNING: No tasks to mark as complete");
        }

    }
//------------------------------------------------------------------------------------------------------------

    private static void disCompleteTasks(TaskList tasks)
    {
        for(int i = 0; i<tasks.runningT;i++)
        {
            TaskItem currentTask= tasks.getTask(i);
            if(currentTask.completed)
            {
                int filler=tasks.getTaskIndex(currentTask);
                String Date=currentTask.date;
                String title=currentTask.title;
                String description=currentTask.description;
                System.out.println(filler+") ["+Date+"] "+title+": "+description);
            }
        }
    }
//------------------------------------------------------------------------------------------------------------

    private static void markIncomplete(TaskList tasks)
    {
        try{
            if(tasks.runningT <= 0)
            {
                throw new NoSuchFieldException();
            }
            System.out.println("Completed Tasks");
            System.out.println("----------------");
            disCompleteTasks(tasks);
            System.out.print("which task will you mark as incompleted");
            int index = input.nextInt();
            input.nextLine();
            tasks.unmarkTask(index);
        }
        catch(InputMismatchException exception){
            System.out.println("WARNING: you must enter the index you wish to mark as incomplete as an integer");
        }
        catch(IndexOutOfBoundsException exception){
            System.out.println("WARNING: you can not mark task as incomplete");
        }
        catch(NoSuchFieldException exception){
            System.out.println("WARNING: No tasks to mark as incomplete");
        }
    }
//------------------------------------------------------------------------------------------------------------

    private static void saveList(TaskList tasks)
    {
        try
        {
            if (tasks.runningT == 0)
            {
                throw new NoSuchFieldException("WARNING: Cannot complete action");
            }
            System.out.println("Enter the file name to save as a txt file:");
            String fileName = input.nextLine();

            tasks.saveList(fileName);
            System.out.println("Task list saved!");
        }
        catch(FileNotFoundException exception)
        {
            System.out.println("WARNING: No file found");
        }
        catch(NoSuchFieldException exception)
        {
            System.out.println("Warning: No tasks to save.");
        }
    }
//------------------------------------------------------------------------------------------------------------

    private static boolean ListOpMenu(int choice, TaskList tasklist)
    {
        boolean stop=false;
        boolean go= true;
        switch(choice)
        {
            case 1:
                System.out.println("Current Tasks");
                System.out.println("--------------------------------");
                displayTasks(tasklist);
                break;

            case 2:
                addTask(tasklist);
                break;

            case 3:
                editTask(tasklist);
                break;

            case 4:
                deleteTask(tasklist);
                break;

            case 5:
                TaskComplete(tasklist);

            case 6:
                markIncomplete(tasklist);
                break;

            case 7:
                saveList(tasklist);
                break;

            case 8:
                return stop;
        }
        return go;
    }
//------------------------------------------------------------------------------------------------------------

    private static void displayTasks(TaskList tasks)
    {
        for(int i = 0; i < tasks.runningT;i++)
        {
            TaskItem currentTask = tasks.getTask(i);
            int filler =tasks.getTaskIndex(currentTask);
            String Date=currentTask.date;
            String title = currentTask.title;
            String description=currentTask.description;

            if(!currentTask.completed)
            {
                System.out.println("-"+filler+") ["+Date+"] "+title+": "+description);
            }
            else
                {
                System.out.println("✓"+filler+") ["+Date+"] "+title+": "+description);
            }
        }

    }
//------------------------------------------------------------------------------------------------------------

    private static void displayOperationMenu()
    {
        System.out.println("\n");
        System.out.println("List of Operations Menu");
        System.out.println("----------------------------------------");
        System.out.println("(1) View list");
        System.out.println("(2) Add Item");
        System.out.println("(3) Edit Item");
        System.out.println("(4) Remove Item");
        System.out.println("(5) Mark Item as Complete");
        System.out.println("(6) Un-mark Item as Complete");
        System.out.println("(7) Save current list");
        System.out.println("(8) Quit to Main Menu");
        System.out.println(">");
    }
//------------------------------------------------------------------------------------------------------------

    private static void displayMainMenu()
    {
        System.out.println("\n");
        System.out.println("Welcome!!");
        System.out.println("Main Menu ");
        System.out.println("--------------------------------");
        System.out.println("(1) Create a new list");
        System.out.println("(2) Load an existing list ");
        System.out.println("(3) Quit");
        System.out.println(">");
    }
//------------------------------------------------------------------------------------------------------------

    public static void main(String[] args)
    {
        int firstc;
        int sechoice;
        int thirchoice;
        boolean lcontinue = true;
        boolean locontinue = true;
        boolean continuemore = true;


        while(lcontinue)
        {
            displayMainMenu();

            try
            {
                firstc=input.nextInt();
                //input.nextLine();

                switch (firstc)
                {
                    case 1 -> {

                        TaskList tasklist = new TaskList();
                        System.out.println("Creating New list");

                        while (locontinue)
                        {
                            displayOperationMenu();
                            try
                            {
                                sechoice = input.nextInt();
                                input.nextLine();

                                locontinue = ListOpMenu(sechoice, tasklist);
                            }
                            catch (IllegalArgumentException | InputMismatchException exception)
                            {
                                System.out.println("WARNING: enter numbers 1-8");
                            }
                        }
                    }
                    case 2 -> {
                        TaskList TaskList = new TaskList();
                        System.out.println("Enter the file name to load: ");
                        String fileName = input.nextLine();

                        TaskList.loadList(fileName);
                        System.out.println("Task list has been loaded.");
                        while (continuemore)
                        {
                            displayOperationMenu();
                            try
                            {
                                thirchoice = input.nextInt();
                                input.nextLine();
                                continuemore = ListOpMenu(thirchoice, TaskList);
                            } catch (IllegalArgumentException | InputMismatchException exception)
                            {
                                System.out.println("WARNING: numbers 1-8 are the only valid choices");

                            }
                        }
                    }
                    case 3 -> lcontinue = false;
                    default -> throw new IllegalArgumentException("WARINGING: cannot continue");
                }
            }
            catch(IllegalArgumentException | InputMismatchException exception)
            {
                System.out.println("WARNING: only enter numbers 1-3 ");
            }
            catch(IOException exception)
            {
                System.out.println("WARNING: file cannot be found");
            }
        }
    }
}
