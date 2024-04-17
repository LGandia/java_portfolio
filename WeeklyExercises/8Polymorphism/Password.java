public class Password implements Encryptable {
    private String password;
    private boolean encrypted;

    public Password(String pwd) {
        password = pwd;
        encrypted = false;
    }

    public void encrypt() {
        if (!encrypted) {
            password = new StringBuilder(password).reverse().toString();
            encrypted = true;
        }
    }

    public String decrypt() {
        if (encrypted) {
            password = new StringBuilder(password).reverse().toString();
            encrypted = false;
        }
        return password;
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public String toString() {
        return password;
    }


    public static void main(String[] args) {
        Encryptable secret = new Secret("Hello, World!");
        Encryptable password = new Password("MyPassword");

        System.out.println("Original Secret: " + secret);
        System.out.println("Original Password: " + password);

        secret.encrypt();
        password.encrypt();

        System.out.println("Encrypted Secret: " + secret);
        System.out.println("Encrypted Password: " + password);

        System.out.println("Decrypted Secret: " + secret.decrypt());
        System.out.println("Decrypted Password: " + password.decrypt());
    }
}

