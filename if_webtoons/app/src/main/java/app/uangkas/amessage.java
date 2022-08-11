package app.uangkas;

public class amessage {
    public String name;
    public String email;
    public String message;
    public String key;

    public amessage() {
    }

    public amessage(String name, String email, String message, String key) {
        this.name = name;
        this.email = email;
        this.message = message;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    @Override
    public String toString()
    {
        return ""+name+"\n"+
                ""+email+"\n"+
                ""+message+"\n";
    }

}
