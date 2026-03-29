package entity.concrete;

public class StudentMember extends Member {

    public StudentMember(Long id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public String getRole(){
        return "Student Member";
    }
}
