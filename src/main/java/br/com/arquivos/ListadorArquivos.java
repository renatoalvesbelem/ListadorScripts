package br.com.arquivos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose.renato on 15/03/2017.
 */
public class ListadorArquivos {

    public static void main(String args[]) throws IOException {
        ArrayList<String> listaVersoes = new ArrayList<String>();
        String diretorioOrigem = "C:\\Projetos\\fXNimitz\\Extras\\configuracao_da_base\\WEB\\Lista de Versões Scripts x Rav\\PUSH";
        String diretorioDestino = "D:\\destino";
        listaVersoes = (ArrayList<String>) new Arquivos().visualizarListaVersoes(diretorioOrigem);
        new Arquivos().copiarScripts(listaVersoes, diretorioDestino);

    }
}

class Arquivos {
    public List<String> visualizarListaVersoes(String diretorio) throws IOException {
        File file = new File(diretorio);
        File afile[] = file.listFiles();
        ArrayList<String> listaVersoes = new ArrayList<String>();
        int i = 0;
        for (int j = afile.length; i < j; i++) {
            File arquivos = afile[i];
            listaVersoes.add(arquivos.getAbsolutePath());
        }
        return listaVersoes;
    }

    public void copiarScripts(ArrayList<String> versoes, String destino) throws IOException {
        for (String versao : versoes) {
            File afile[] = new File(versao).listFiles();
            int i = 0;
            for (int j = afile.length; i < j; i++) {
                afile[i].getName();
                if (!afile[i].getName().equals("NET")) {
                    copy(afile[i].getAbsoluteFile(), new File(destino));
                }
            }
        }

    }

    public void copy(File src, File dst) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);           // Transferindo bytes de entrada para saída
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }

}
