/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bichinho_virtual;

/**
 *
 * @author José Pedro
 */
import java.util.Scanner;

class Bichinho{
    String nome;
    String classe;
    String familia;
    int idade;
    boolean vivo;
    int caloria;
    int forca;

    // Construtor para inicializar o Bichinho
    public Bichinho(String nome, String classe, String familia) {
        this.nome = nome;
        this.classe = classe;
        this.familia = familia;
        this.idade = 0;
        this.vivo = true;
        this.caloria = 10;
        this.forca = 10;
    }

    // Método para comer
    public void comer() {
        if (!vivo) {
            System.out.println(nome + " infelizmente esta morto e nao pode comer!");
            return;
        }
        if (caloria < 100) {
            caloria += 10;
            forca -= 2;
            System.out.println("\n" + nome + " comeu e ganhou 10 de caloria! \nCaloria atual: " + caloria + "\nForca atual: " + forca);
        } else {
            System.out.println(nome + " esta com a barriguinha cheia e nao consegue comer mais!");
        }
    }

    // Método para dormir
    public void dormir() {
        if (!vivo) {
            System.out.println(nome + " infelizmente esta morto e nao pode dormir!");
            return;
        }
        forca += 10;
        caloria -= 2;
        System.out.println("\n" + nome + " esta tirando um cochilinho e recuperou 10 de forca! \nForca atual: " + forca + "\nCaloria atual: " + caloria);
    }

    // Método para correr
    public void correr() {
        if (!vivo) {
            System.out.println(nome + " infelizmente esta morto e nao pode correr.");
            return;
        }
        if (caloria > 0 && forca > 0) {
            forca -= 5;
            caloria -= 5;
            System.out.println("\n" + nome + " fez uma corridinha, ele ficou 5 pontos mais fraco e 5 pontos com fominha! \nForca atual: " + forca + "\nCaloria atual: " + caloria);
        } else {
            System.out.println(nome + " esta exausto e nao consegue correr, acho que ele precisa descansar um pouquinho!.");
        }
    }

    // Método para morrer
    public void morrer() {
        vivo = false;
        forca = 0;
        System.out.println("\n" + nome + " infelizmente virou uma estrelinha!");
    }

    // Método para verificar o estado do Bichinho
    public boolean estaVivo() {
        return vivo;
    }
}

public class Bichinho_Virtual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao jogo do Bichinho Virtual!");
        System.out.print("Digite o nome do seu bichinho: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a classe do seu bichinho: ");
        String classe = scanner.nextLine();
        System.out.print("Digite a familia do seu bichinho: ");
        String familia = scanner.nextLine();

        Bichinho Bichinho = new Bichinho(nome, classe, familia);
        System.out.println("\n" + nome + " nasceu com 10 de forca e 10 de calorias!");

        while (Bichinho.estaVivo()) {
            System.out.println("\nO que o " + nome + " ira fazer agora?");
            System.out.println("1. Comer");
            System.out.println("2. Dormir");
            System.out.println("3. Correr");
            System.out.println("4. Morrer");
            int acao = scanner.nextInt();

            switch (acao) {
                case 1 -> Bichinho.comer();
                case 2 -> Bichinho.dormir();
                case 3 -> Bichinho.correr();
                case 4 -> Bichinho.morrer();
                default -> System.out.println("Escolha invalida. Tente novamente!");
            }
        }

        System.out.println("\nGAME OVER!");
        scanner.close();
    }
}

