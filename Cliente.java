public class Cliente{
    private String nome, email;
    private int idade;

    public Cliente(String nome, String email, int idade){
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }   

    public Cliente() {
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", email='" + getEmail() + "'" +
            ", idade='" + getIdade() + "'" +
            "}";
    }
    
}