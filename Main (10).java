import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] azbmorze = {
                {"A", ".-"},
                {"B", "-..."},
                {"C", "-.-."},
                {"D", "-.."},
                {"E", "."},
                {"F", "..-."},
                {"G", "--."},
                {"H", "...."},
                {"I", ".."},
                {"J", ".---"},
                {"K", "-.-"},
                {"L", ".-.."},
                {"M", "--"},
                {"N", "-."},
                {"O", "---"},
                {"P", ".--."},
                {"Q", "--.-"},
                {"R", ".-."},
                {"S", "..."},
                {"T", "-"},
                {"U", "..-"},
                {"V", "...-"},
                {"W", ".--"},
                {"X", "-..-"},
                {"Y", "-.--"},
                {"Z", "--.."}};
        System.out.print("Добро пожаловать!");
        while (true){
            boolean eror = false;
            boolean eror1 = false;
            String enc = "";
            String dec = "";
            System.out.println(" ");
            System.out.println("Выберите команду и введите текст!");
            String comand = sc.next();
            if (comand.equalsIgnoreCase("encrypt")) {
                int y = 0;
                String tecst = sc.nextLine();
                tecst = tecst.trim();
                int bInd = 0;
                if (tecst.equalsIgnoreCase("exit")) {break;}
                else{
                    for (int i = 0; i < tecst.length(); i++) {
                        String theSimvol = tecst.substring(bInd, i + 1);
                        bInd += theSimvol.length();
                        if(tecst.charAt(i)!=' ') {
                            for (y = 0; y < azbmorze.length; y++) {
                                if (azbmorze[y][0].equals(theSimvol)) {
                                    enc += (azbmorze[y][1]);
                                    enc += (" ");
                                    break;
                                }

                            }
                        }
                        else enc+=" ";

                        if(y == azbmorze.length) {
                            eror = true;}
                    }
                    if(!eror){
                        System.out.println(enc);}
                    else{
                        System.out.println("Неправильно введен текст!");
                    }
                }
            }
            else if (comand.equalsIgnoreCase("decrypt")) {
                int g = 0;
                String azbtecst = sc.nextLine();
                azbtecst = azbtecst.trim();
                int beginInd = 0;
                if (azbtecst.equalsIgnoreCase("exit")) break;
                else {
                    for (int i = 0; i < azbtecst.length(); i++) {
                        if (azbtecst.charAt(i) == ' ') {
                            String str = azbtecst.substring(beginInd, i);
                            beginInd += str.length() + 1;
                            for (g = 0; g < azbmorze.length; g++) {
                                if (azbmorze[g][1].equals(str)) {
                                    dec += azbmorze[g][0];
                                    break;
                                }
                            }
                            if(g == azbmorze.length && azbtecst.charAt(i)!=' ') {
                                eror1 = true;}
                            if (azbtecst.charAt(i+1) == ' ' && azbtecst.charAt(i) == ' ' || azbtecst.charAt(i-1) == ' ' && azbtecst.charAt(i) == ' ') dec+=" ";
                        }
                    }
                    if(!eror1){
                        System.out.print(dec);}
                    else{
                        System.out.println("Неправильно введен текст!");}
                }
                int v = 0;
                boolean error2 = false;
                String last = "";
                String laststr = azbtecst.substring(beginInd);
                for ( v = 0; v < azbmorze.length; v++) {
                    if (azbmorze[v][1].equals(laststr)) {
                        last+=azbmorze[v][0];
                        break;}
                    }
                if(v==azbmorze.length){
                    error2=true;}
                if(!error2){
                    System.out.println(last);
                }
                else {
                    System.out.println("Неправильно введен текст!");
                }
            }

            else if(comand.equalsIgnoreCase("exit")) break;
            else{
                System.out.print("Команда неверная, повторите попытку!");
                String del = sc.nextLine();
            }
        }
        System.out.print("До свидания!");
    }
}