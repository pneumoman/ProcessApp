package processApp.struct;

import javax.persistence.*;


@Entity
public class Step
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId()
	{
		return Id;
	}
	public void setId(int id)
	{
		Id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	@Embedded
	@AttributeOverrides(value = {
			@AttributeOverride(column = @Column(name = "START_SCHED"), name = "start"), 
			@AttributeOverride(column = @Column(name = "STOP_SCHED"), name = "stop") 
			}
			)
	public Duration getSched()
	{
		return sched;
	}
	public void setSched(Duration sched)
	{
		this.sched = sched;
	}
	@Embedded
	@AttributeOverrides(value = {
			@AttributeOverride(column = @Column(name = "START_ACTUAL"), name = "start"), 
			@AttributeOverride(column = @Column(name = "STOP_ACTUAL"), name = "stop") 
			}
			)

	public Duration getActual()
	{
		return actual;
	}
	public void setActual(Duration actual)
	{
		this.actual = actual;
	}
	public Step()
	{
		
	}
	public Step(String name)
	{
		this.name=name;
	}
	int Id;
	String name;
	String type;
	Duration sched;
	Duration actual;
	
}
