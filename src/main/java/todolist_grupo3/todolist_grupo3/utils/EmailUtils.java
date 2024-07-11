package todolist_grupo3.todolist_grupo3.utils;

public class EmailUtils {

    /**
     * this class represents the form for email text that is sent to new user for validation
     * the method is called from EmailServiceImpl
     * @param name
     * @param host
     * @param token
     * @return
     */
    public static String getEmailMessage(String name, String host, String token){
        String verificationUrl = host +"/verify/account?token=" + token;
        return "Hello " + name + ",\n Your account in to do list has been created. Please click on the link below to verify it. \n\n" +
                verificationUrl + "\n\nThank you!";
    }
}
