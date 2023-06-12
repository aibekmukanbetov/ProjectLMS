package LMS.model;

public class Admin {
    private String email = "admin@gmail.com";
    private String password = "admin";

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String updateAdminPassword(String email, String newPassword){
        try {
            if (getEmail().equals(email)){
                if (newPassword.length()<7){
                    setPassword(newPassword);
                } else {
                    throw new RuntimeException("Пароль должен быть не меньше 7 символов");
                }

            } else {
                 throw new RuntimeException("Такой логин не существует");
            }
        } catch (RuntimeException r){
            System.out.println(r.getMessage());
        }
        return "Пароль успешно изменен";
    }
}
