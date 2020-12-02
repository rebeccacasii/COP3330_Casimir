import java.time.format.DateTimeFormatter;
import java.time.DateTimeException;
import java.time.LocalDate;

public class TaskItem
{

    //private String title;
     String title;
     String description;
     String date;
     boolean completed = false;

    public String getTitle()
    {
        return title;
    }
//------------------------------------------------------------------------------------------------------------

    public void checkTitle(String title)
    {
        if(title.length()<1)
        {
            throw new IllegalArgumentException("WARNING: Title characters invalid");
        }
    }
//------------------------------------------------------------------------------------------------------------

    public void setTitle(String title)
    {
        checkTitle(title);
        this.title=title;
    }

//------------------------------------------------------------------------------------------------------------

    public String getDescription()
    {
        return description;
    }
//------------------------------------------------------------------------------------------------------------

    public void setDescription(String description)
    {
        this.description = description;

    }
//------------------------------------------------------------------------------------------------------------

    public LocalDate getDate(String userDate)
    {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(userDate, dateFormat);
    }
//------------------------------------------------------------------------------------------------------------

    public String getDueDate()
    {
        return date;
    }
//------------------------------------------------------------------------------------------------------------

    public void checkDate(String date)
    {
        LocalDate currentDate=java.time.LocalDate.now();

        if(currentDate.isAfter(getDate(date)))
        {
            throw new DateTimeException("WARNING: Invalid due date, task not created");
        }
    }
//------------------------------------------------------------------------------------------------------------

    public void DueDate(String date)
    {
        checkDate(date);
        this.date=date;

    }
//------------------------------------------------------------------------------------------------------------

    public String taskComplete()
    {
        if(completed)
        {
            return"✓";
        }
        else
            {
            return "-";
        }
    }


}
