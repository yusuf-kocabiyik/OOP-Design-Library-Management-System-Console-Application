package entity;

import java.util.Objects;

public abstract class Person {
    private Long id;
    private String name;

    public Person(Long id, String name){
        this.id=id;
        this.name=name;
    }

    public abstract String getRole();

    public Long getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    @Override
    public String toString(){
        return "Person : " + name;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this)
            return true;
        if(obj == null || obj.getClass() != getClass())
            return false;

        Person person = (Person) obj;
        return person.id.equals(id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }



}
