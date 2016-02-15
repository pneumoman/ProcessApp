package processApp.struct;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import sun.util.calendar.JulianCalendar;
@Embeddable
public class Duration
{
	public Duration(){};
	public Duration(Date begin,Date end)
	{
		setStart(begin);
		setStop(end);
	}
	@Temporal(TemporalType.DATE)
	public Date getStart()
	{
		return start;
	}

	public void setStart(Date start)
	{
		this.start = start;
	}
	@Temporal(TemporalType.DATE)
	public Date getStop()
	{
		return stop;
	}

	public void setStop(Date stop)
	{
		this.stop = stop;
	}
	@Transient
	public long getDays()
	{
		long diff = stop.getTime()-start.getTime();
		        /*ms/s*sec/min*min/hr*hr/day*/
		return  diff/100060/60/24;
	}
	@Temporal(TemporalType.DATE)
	Date start;
	@Temporal(TemporalType.DATE)
	Date stop;
}
