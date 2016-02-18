/**
 * Created by ico_gabriel on 28/10/2015.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        int [][] matriz;
        ArrayList<Pessoa> lista_pessoas = new ArrayList();
        int id_pessoa = -1;

        FileReader fileReader = new FileReader("C:/grafo/matriz_rede_social.txt");
        BufferedReader reader = new BufferedReader(fileReader);


        /////////////  ADIÇÃO DE PESSOAS  /////////////
        lista_pessoas.add(new Pessoa(++id_pessoa, "Nom1",20));
        lista_pessoas.add(new Pessoa(++id_pessoa, "Nom2", 40));
        lista_pessoas.add(new Pessoa(++id_pessoa, "Nome3", 15));
        lista_pessoas.add(new Pessoa(++id_pessoa, "Nom4", 14));
        //just type sout
        System.out.println("Elements from lista_pessoas: "+lista_pessoas);
        System.out.println("Itens dos Elements from lista_pessoas: ");

        for(Pessoa pessoa: lista_pessoas) {
            System.out.println(pessoa);  // Will invoke overrided `toString()` method
        }
        System.out.println("Antes da remocao");
        System.out.println(lista_pessoas);
        for(int i = 0; i < lista_pessoas.size(); i++){
            System.out.println(lista_pessoas.get(i).getId());
            System.out.println(lista_pessoas.get(i).getIdade());
            System.out.println(lista_pessoas.get(i).getNome());
        }
        /////////////  ADIÇÃO DE PESSOAS  /////////////

        System.out.println("//////////////////");

        /////////////  REMOÇÃO DE PESSOAS  /////////////
        /*lista_pessoas.remove(0);
        System.out.println("Após a remocao");
        System.out.println(lista_pessoas);
        for(int i = 0; i < lista_pessoas.size(); i++){
            System.out.println(lista_pessoas.get(i).getId());
            System.out.println(lista_pessoas.get(i).getIdade());
            System.out.println(lista_pessoas.get(i).getNome());
        }
        */
        /////////////  REMOÇÃO DE PESSOAS  /////////////

        System.out.println("//////////////////");



        List<String> linhas = new ArrayList<String>();
        String data = null;
        while((data = reader.readLine()) != null){
            linhas.add(data);
        }
        matriz = new int[linhas.size()][linhas.size()];
        int i = 0;
        for (String l : linhas) {
            StringTokenizer token = new StringTokenizer(l, " ");
            int j = 0;
            while (token.hasMoreTokens()) {
                String t = token.nextToken();
                matriz[i][j] = Integer.parseInt(t);
                j++;
            }
            i++;
        }

        /////////////  CONEXÃO DE PESSOAS  /////////////
        //matriz[1][0] = 1;
        //matriz[0][1] = 1;
        /////////////  CONEXÃO DE PESSOAS  /////////////

        for (i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }

        fileReader.close();
        reader.close();

        Grafo grafo = new Grafo(matriz);

        /////////////  CONEXÃO DE PESSOAS  /////////////
        grafo.adicionaConexao(lista_pessoas.get(0).getId(), lista_pessoas.get(1).getId());
        grafo.adicionaConexao(lista_pessoas.get(0).getId(), lista_pessoas.get(2).getId());
        grafo.adicionaConexao(lista_pessoas.get(2).getId(), lista_pessoas.get(3).getId());
        /////////////  CONEXÃO DE PESSOAS  /////////////

        System.out.println("Num Vértices: " + grafo.numeroVertices());
        System.out.println("Num arestas: " + grafo.numeroArestas());
        System.out.println("Arestas:" + grafo.nomeArestas());
        System.out.println("Loops: " + grafo.loops());
        System.out.println("Num arestas paralelas: " + grafo.numArestasParalelas());
        //System.out.println("Conexo: " + grafo.isConexo());

        System.out.println("Graus:");
        int [] graus = grafo.graus();
        for (i = 0; i < graus.length; i++) {
            System.out.println(i + " " + graus[i]);
        }

        System.out.println("Matriz incidencia");
        int [][] matrizIncidencia = grafo.matrizIncidencia();
        for (i = 0; i < matrizIncidencia.length; i++) {
            for (int j = 0; j < matrizIncidencia[i].length; j++) {
                System.out.print(matrizIncidencia[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println("Busca Largura:");
        int [] distancia = grafo.buscaLarguraList(1);
        for (i = 0; i < distancia.length; i++) {
            System.out.println(i + " " + distancia[i]);
        }
        System.out.println("Caminho: " + grafo.caminho(1, 3, distancia));


        System.out.println("Busca Profundidade:");
        distancia = grafo.buscaProfundidade(1);
        for (i = 0; i < distancia.length; i++) {
            System.out.println(i + " " + distancia[i]);
        }
        System.out.println("Caminho: " + grafo.caminho(1, 3, distancia));


        System.out.println("Árvore: " + grafo.prim(0));
        System.out.println("Árvore: " + grafo.kruskal());

        System.out.println("Dijikstra:");
        distancia = grafo.djikistra(0);
        for (i = 0; i < distancia.length; i++) {
            System.out.println(i + " " + distancia[i]);
        }

        System.out.println("Floyd-Warshall");
        int [][] matrizD = grafo.floydWarshall();
        for (i = 0; i < matrizD.length; i++) {
            for (int j = 0; j < matrizD[i].length; j++) {
                System.out.print(matrizD[i][j] + " ");
            }
            System.out.println("");
        }

    }

}