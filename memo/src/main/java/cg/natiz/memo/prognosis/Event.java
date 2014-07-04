package cg.natiz.memo.prognosis;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Named;

/**
 * Bet event
 * @author natiz
 *
 */
@Named
@SuppressWarnings("serial")
public class Event implements Serializable {
	
	private Long id;
	private String name;
	private String description;	
	private Type type;	
	/**
	 * Number of challenger
	 */
	private Integer length;
	
	/*Technical attributes */	
	private Date creationDate;	
	private Date beginDate;
	private Date endDate;
	
	/**
	 * Event prognosis 
	 */
	private Set<Prognosis> prognosis;

	@PostConstruct
	public void init() {
		this.creationDate = new Date();
		this.beginDate = new Date();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.creationDate);
		calendar.add(Calendar.DAY_OF_MONTH, 15);
		this.endDate = calendar.getTime();
		
		this.prognosis = new HashSet<Prognosis>();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Prognosis> getPrognosis() {
		return prognosis;
	}

	public void setPrognosis(Set<Prognosis> prognosis) {
		this.prognosis = prognosis;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
