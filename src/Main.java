import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner ler = new Scanner(System.in);

        while (true) {
            System.out.println("--- Prova Java Lista ---");
            System.out.println("1 - Lista Padrao");
            System.out.println("2 - Escrever Propria");
            System.out.println("3 - Sair");

            Integer escolha = ler.nextInt();

            switch (escolha) {
                case 1:
                    List<Integer> lista = converterParaNumeros(getListaPadrao());
                    System.out.println(lista);
                    break;
                case 2:
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }
        }
    }

    public static Integer getMinimo(List<Integer> numeros) {
        Integer min = Integer.MAX_VALUE;
        for (Integer numero : numeros) {
            min = Integer.min(min, numero);
        }

        return min;
    }

    public static Integer getMaximo(List<Integer> numeros) {
        Integer max = Integer.MIN_VALUE;
        for (Integer numero : numeros) {
            max = Integer.max(max, numero);
        }

        return max;
    }

    public static List<String> getListaPadrao() {
        return Arrays.asList("4", "7", "1", "2", "5");
    }

    public static List<Integer> converterParaNumeros(List<String> numeros) {
        List<Integer> novaLista = new ArrayList<>();

        for (String strNumero : numeros) {
            novaLista.add(Integer.parseInt(strNumero));
        }

        return novaLista;
    }
}
