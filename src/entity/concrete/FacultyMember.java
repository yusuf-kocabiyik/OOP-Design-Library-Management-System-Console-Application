package entity.concrete;

public class FacultyMember extends Member {

    public FacultyMember(Long id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public String getRole(){
        return "Faculty Member";
    }
}
