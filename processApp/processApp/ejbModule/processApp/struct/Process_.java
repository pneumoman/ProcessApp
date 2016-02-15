package processApp.struct;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-12-10T21:55:07.444-0500")
@StaticMetamodel(Process.class)
public class Process_ {
	public static volatile SingularAttribute<Process, Integer> id;
	public static volatile ListAttribute<Process, Step> steps;
	public static volatile SingularAttribute<Process, Duration> processTime;
	public static volatile SingularAttribute<Process, String> name;
}
