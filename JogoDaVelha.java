import java.util.Scanner;

public class JogoDaVelha{
    public static void main(String[] args) {
        
        Campo[][] jogoDaVelha = new Campo[3][3];
        char simboloAtual = 'X';
        boolean game = true;
        String vitoria = "";
        Scanner scanner = new Scanner(System.in);

        iniciarJogo(jogoDaVelha);

        while(game){
            desenhaJogo(jogoDaVelha);
            vitoria = verificaVitoria(jogoDaVelha);
            if(!vitoria.equals("")){
                System.out.printf("Jogador %s venceu%n", vitoria);
                break;
            }
            try{
                if(verificarJogada(jogoDaVelha, jogar(scanner, simboloAtual), simboloAtual)){
                    if(simboloAtual == 'X'){
                        simboloAtual = 'O';
                    }else{
                        simboloAtual = 'X';
                    }
                }

            }catch(Exception e){
                System.err.println("Erro");
            }
        }
            System.out.println("Fim de jogo!");
    }

    public static void desenhaJogo(Campo[][] jogoDaVelha){
        
        limpaTela();
        System.out.println("   0   1   2   ");
        System.out.printf("0  %c | %c | %c %n", jogoDaVelha[0][0].getSimbolo(), jogoDaVelha[0][1].getSimbolo(), jogoDaVelha[0][2].getSimbolo());
        System.out.println("  ------------");
        System.out.printf("1  %c | %c | %c %n", jogoDaVelha[1][0].getSimbolo(), jogoDaVelha[1][1].getSimbolo(), jogoDaVelha[1][2].getSimbolo());
        System.out.println("  ------------");
        System.out.printf("2  %c | %c | %c %n", jogoDaVelha[2][0].getSimbolo(), jogoDaVelha[2][1].getSimbolo(), jogoDaVelha[2][2].getSimbolo());
    }

    
    public static void limpaTela(){
        for(int cont = 0; cont<200; cont++){
            System.out.println("");
        }
    }

    public static int[] jogar(Scanner scanner, char simboloAtual){
        int[] p = new int[2];
        System.out.printf("%s %c%n", "Quem joga:  ", simboloAtual);
        System.out.println("Informe a linha: ");
        p[0] = scanner.nextInt();
        System.out.println("Informe a coluna: ");
        p[1] = scanner.nextInt();
        return p;
    }

    public static boolean verificarJogada(Campo[][] jogoDaVelha, int[] p, char simboloAtual){
        if(jogoDaVelha[p[0]][p[1]].getSimbolo() == ' '){
            jogoDaVelha[p[0]][p[1]].setSimbolo(simboloAtual);
            return true;
        }else{
            return false;
        }
    }

    public static void iniciarJogo(Campo[][] jogoDaVelha){
        for(int l = 0; l<3; l++){
            for(int c = 0; c<3; c++){
                jogoDaVelha[l][c] = new Campo();
            }
        }
    }

    public static String verificaVitoria(Campo[][] jogoDaVelha) {
        for (int i = 0; i < 3; i++) {
            if (jogoDaVelha[i][0].getSimbolo() == jogoDaVelha[i][1].getSimbolo()
                    && jogoDaVelha[i][0].getSimbolo() == jogoDaVelha[i][2].getSimbolo()
                    && jogoDaVelha[i][0].getSimbolo() != ' ') {
                return String.valueOf(jogoDaVelha[i][0].getSimbolo());
            }
        }
        for (int i = 0; i < 3; i++) {
            if (jogoDaVelha[0][i].getSimbolo() == jogoDaVelha[1][i].getSimbolo()
                    && jogoDaVelha[0][i].getSimbolo() == jogoDaVelha[2][i].getSimbolo()
                    && jogoDaVelha[0][i].getSimbolo() != ' ') {
                return String.valueOf(jogoDaVelha[0][i].getSimbolo());
            }
        }
        if (jogoDaVelha[0][0].getSimbolo() == jogoDaVelha[1][1].getSimbolo()
                && jogoDaVelha[0][0].getSimbolo() == jogoDaVelha[2][2].getSimbolo()
                && jogoDaVelha[0][0].getSimbolo() != ' ') {
            return String.valueOf(jogoDaVelha[0][0].getSimbolo());
        }

        if (jogoDaVelha[0][2].getSimbolo() == jogoDaVelha[1][1].getSimbolo()
                && jogoDaVelha[0][2].getSimbolo() == jogoDaVelha[2][0].getSimbolo()
                && jogoDaVelha[0][2].getSimbolo() != ' ') {
            return String.valueOf(jogoDaVelha[0][2].getSimbolo());
        }
        return "";
    }
}




