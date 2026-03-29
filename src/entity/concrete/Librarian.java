package entity.concrete;

import entity.Person;

public class Librarian extends Person {
        private String password;
    
        public Librarian(Long id,String name){
            super(id,name);
        }
    
        public Librarian(Long id, String name,String password) {
            super(id, name);
            this.password=password;
        }
        //GET PASSWORD TASARIM AÇISINDAN UYGUN GÖRÜLMEYİP YAZILMADI.

        public  void changePassword(String password){
            this.password=password;
        }
    
        @Override
        public String getRole() {
            return "Librarian";
        }
        @Override
        public String toString(){
            return "Librarian : " + getName();
        }
    }
