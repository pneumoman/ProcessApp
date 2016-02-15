package processApp.struct;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-12-09T22:54:55.021-0500")
@StaticMetamodel(Step.class)
public class Step_ {
	public static volatile SingularAttribute<Step, Integer> id;
	public static volatile SingularAttribute<Step, Duration> sched;
	public static volatile SingularAttribute<Step, Duration> actual;
	public static volatile SingularAttribute<Step, String> name;
	public static volatile SingularAttribute<Step, String> type;
}
