package com.example.demo.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

@Entity
public class Painting 
{
	//DEFINING VARIABLES
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="author_name", columnDefinition="varchar(30) default 'Anonymous'", nullable = false)
	private String authorName = "Anonymous";
	
	private String name;
	
	private int price;
	
	@Column(name="creation_date_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime creationDateTime;
	
	@ManyToOne
	private Store store;
	//------------------
		
	//CREATING DEFAULT OBJECT
	public Painting()
	{
	}
	//-----------------------
	
	
	//GETTER & SETTER FOR AUTHORNAME
	public String getAuthorName() 
	{
		return authorName;
	}
	public void setAuthorName(String authorName) 
	{
		this.authorName = authorName;
	}
	//------------------------------
	
	//GETTER & SETTER FOR PAINTING´S NAME
	public String getName() {
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	//-----------------------------------
	
	//GETTER & SETTER FOR PRICE
	public int getPrice() 
	{
		return price;
	}
	public void setPrice(int price) 
	{
		this.price = price;
	}
	//-------------------------
	
	//GETTER & SETTER FOR CREATIONDATETIME
	public LocalDateTime getCreationDateTime() 
	{
		return creationDateTime;
	}
	public void setCreationDateTime(LocalDateTime creationDateTime) 
	{
		this.creationDateTime = creationDateTime;
	}
	//------------------------------------
	
	//GETTER & SETTER FOR STORE
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	//-------------------------
	
	
	//CREATING PREPERSIST OBJECT
	@PrePersist
	public void prePersist()
	{
		this.creationDateTime = LocalDateTime.now();
	}
	//--------------------------
	
	
	


	//GETTER FOR ID (NO NEED FOR SETTER BC OF AUTOINCREMENT)
	public Integer getId() 
	{
		return id;
	}
	//------------------------------------------------------

	//GENERATING HASHCODE
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	//-----------------

	//GENERATING EQUALS
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Painting other = (Painting) obj;
		if (id == null) 
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	//---------------
	
}
