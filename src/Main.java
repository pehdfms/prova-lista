import java.util.*;

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

            List<Double> lista = new ArrayList<>();

            Integer escolha;

            try {
                escolha = ler.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Escolha deve ser um numero inteiro!");
                continue;
            } finally {
                ler.nextLine();
            }

            switch (escolha) {
                case 1:
                    lista = converterParaNumeros(getListaPadrao());
                    break;
                case 2:
                    lista = getListaUsuario();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }

            printInformacoes(lista);
        }
    }

    public static List<String> getListaPadrao() {
        return Arrays.asList("4.0", "7.2", "1", "2.5", "5");
    }

    public static List<Double> getListaUsuario() {
        Scanner ler = new Scanner(System.in);
        List<Double> lista = new ArrayList<>();

        System.out.println();
        System.out.println("--- Criar Lista ---");
        while (true) {
            System.out.println(lista);

            System.out.println("1 - Adicionar numero");
            System.out.println("2 - Remover por Indice");
            System.out.println("3 - Confirmar");

            Integer escolha;

            try {
                escolha = ler.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Escolha deve ser um numero inteiro!");
                continue;
            } finally {
                ler.nextLine();
            }

            switch (escolha) {
                case 1:
                    System.out.println("Escreva um novo numero: ");


                    Double novoNumero;
                    try {
                        novoNumero = ler.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada invalida! (Talvez tente trocar ',' por '.' ou vice-versa se seu numero tiver casa decimal?)");
                        break;
                    } finally {
                        ler.nextLine();
                    }

                    lista.add(novoNumero);
                    break;
                case 2:
                    System.out.println("Escreva o indice que deseja deletar");

                    Integer indice;

                    try {
                        indice = ler.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Indice deve ser um numero inteiro!");
                        break;
                    } finally {
                        ler.nextLine();
                    }

                    if (indice < 0 || indice >= lista.size()) {
                        System.out.println("Indice nao presente na lista.");
                        break;
                    }

                    lista.remove(lista.get(indice));
                    break;
                case 3:
                    return lista;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }
        }
    }

    public static Double getMinimo(List<Double> numeros) {
        if (numeros.size() == 0) return 0.0;

        Double min = Double.MAX_VALUE;
        for (Double numero : numeros) {
            min = Double.min(min, numero);
        }

        return min;
    }

    public static Double getMaximo(List<Double> numeros) {
        if (numeros.size() == 0) return 0.0;

        Double max = Double.MIN_VALUE;
        for (Double numero : numeros) {
            max = Double.max(max, numero);
        }

        return max;
    }

    public static Double somatoria(List<Double> numeros) {
        Double sum = 0.0;

        for (Double numero : numeros) {
            sum += numero;
        }

        return sum;
    }

    public static Double getMedia(List<Double> numeros) {
        if (numeros.size() == 0) return 0.0;
        return somatoria(numeros) / numeros.size();
    }

    public static List<Double> converterParaNumeros(List<String> numeros) {
        List<Double> novaLista = new ArrayList<>();

        for (String strNumero : numeros) {
            novaLista.add(Double.parseDouble(strNumero));
        }

        return novaLista;
    }

    public static void printInformacoes(List<Double> lista) {
        System.out.println();

        System.out.println("Lista: "  + lista);
        System.out.println("Minimo: " + getMinimo(lista));
        System.out.println("Maximo: " + getMaximo(lista));
        System.out.println("Media: "  + getMedia(lista));

        System.out.println();
    }
}
