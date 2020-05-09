package Read_and_Writer;
import java.io.*;

class FileRead {
    public void copy(String fileName) {
        try(Reader in = new FileReader(fileName)) {
            // читаем посимвольно
            int c;
            while((c=in.read())!=-1){

                System.out.print((char)c);
        } }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}