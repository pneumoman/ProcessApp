package processApp.struct;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Process
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "STEP_ID")
	public List<Step> getSteps()
	{
		return steps;
	}

	public void setSteps(List<Step> steps)
	{
		this.steps = steps;
	}

	@Embedded
	public Duration getProcessTime()
	{
		return processTime;
	}

	public void setProcessTime(Duration processTime)
	{
		this.processTime = processTime;
	}

	public Process()
	{
		this.steps = new ArrayList<Step>();
	}

	public Process(String name)
	{
		this.name = name;
		this.steps = new ArrayList<Step>();
	}

	public boolean addStep(Step step)
	{
		return this.steps.add(step);
	}

	public boolean removeStep(Step step)
	{
		return this.steps.remove(step);
	}

	int id;
	String name;
	List<Step> steps;
	Duration processTime;

}
